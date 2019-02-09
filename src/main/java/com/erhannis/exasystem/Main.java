/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem;

import com.erhannis.exasystem.architecture.Exa;
import com.erhannis.exasystem.architecture.ExaHost;
import com.erhannis.exasystem.architecture.ExaLink;
import com.erhannis.exasystem.architecture.ExaSystem;
import com.erhannis.exasystem.architecture.HardwareRegister;
import com.erhannis.exasystem.architecture.registers.BuiltInRegisters;
import com.erhannis.exasystem.code.Addi;
import com.erhannis.exasystem.code.Copy;
import com.erhannis.exasystem.code.Instruction;
import com.erhannis.exasystem.code.Jump;
import com.erhannis.exasystem.code.Mark;
import com.erhannis.exasystem.code.argument.ExaNumber;
import com.erhannis.exasystem.code.argument.Label;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import jcsp.lang.Barrier;
import jcsp.lang.CSTimer;
import jcsp.lang.Parallel;
import jcsp.lang.ProcessManager;

/**
 *
 * @author erhannis
 */
public class Main {
  public static void main(String[] args) {
    test();
  }

  /**
   *
   * @param syncBarrier
   * @param processes
   * @return
   */
  public static ExaSystem tecRedshift(Barrier syncBarrier, Parallel processes) {
    ExaSystem system = new ExaSystem(syncBarrier);
    ExaHost input = new ExaHost(syncBarrier, "INPUT", 20);
    // This is a little weird, because the sides are unlabeled and the core is labeled CORE,
    // but if you go there they've HOST NULL and HOME respectively.
    ExaHost side1 = new ExaHost(syncBarrier, "SIDE1", 3);
    ExaHost core = new ExaHost(syncBarrier, "CORE", 18);
    ExaHost side2 = new ExaHost(syncBarrier, "SIDE2", 3);
    ExaHost sound = new ExaHost(syncBarrier, "SOUND", 20);
    system.hosts.add(input);
    system.hosts.add(side1);
    system.hosts.add(core);
    system.hosts.add(side2);
    system.hosts.add(sound);

    input.registers.add(new HardwareRegister("PADX"));
    input.registers.add(new HardwareRegister("PADY"));
    input.registers.add(new HardwareRegister("PADB"));
    input.registers.add(new HardwareRegister("EN3D"));

    sound.registers.add(new HardwareRegister("SQR0"));
    sound.registers.add(new HardwareRegister("SQR1"));
    sound.registers.add(new HardwareRegister("TRI0"));
    sound.registers.add(new HardwareRegister("NSE0"));

    core.links.add(new ExaLink(new ExaNumber(800), input));
    core.links.add(new ExaLink(new ExaNumber(801), sound));
    core.links.add(new ExaLink(new ExaNumber(802), side1));
    core.links.add(new ExaLink(new ExaNumber(803), side2));

    input.links.add(new ExaLink(new ExaNumber(-1), core));
    sound.links.add(new ExaLink(new ExaNumber(-1), core));
    side1.links.add(new ExaLink(new ExaNumber(-1), core));
    side2.links.add(new ExaLink(new ExaNumber(-1), core));

    //TODO I don't yet know how we're going to code register effects.
    processes.addProcess(system);
    processes.addProcess(input);
    processes.addProcess(side1);
    processes.addProcess(core);
    processes.addProcess(side2);
    processes.addProcess(sound);

    return system;
  }

  public static void test() {
    Barrier syncBarrier = new Barrier();
    Parallel processes = new Parallel();
    ExaSystem redshift = tecRedshift(syncBarrier, processes);

    ArrayList<Instruction> xaCode = new ArrayList<>();
    HashMap<String, Integer> xaLabels = new HashMap<>();
    xaCode.add(new Copy(new ExaNumber(1), BuiltInRegisters.X));
    xaLabels.put("LOOP", 1);
    xaCode.add(new Addi(BuiltInRegisters.X, BuiltInRegisters.X, BuiltInRegisters.X));
    xaCode.add(new Jump(new Label("LOOP")));
    Exa xa = new Exa(syncBarrier, UUID.randomUUID().toString(), xaCode, xaLabels);

    ArrayList<Instruction> xbCode = new ArrayList<>();
    Exa xb = new Exa(syncBarrier, UUID.randomUUID().toString(), xbCode);

    processes.addProcess(xa);
    processes.addProcess(xb);

    // Manually adding an EXA to a host isn't a good idea under normal circumstances, but if you're doing setup and know where things are, it's prolly fine
    redshift.hosts.stream().filter(h -> "CORE".equals(h.name)).findAny().get().exas.add(xa);
    redshift.hosts.stream().filter(h -> "CORE".equals(h.name)).findAny().get().exas.add(xb);
    //TODO May need to add the host to the EXA, as well

    // Idle timer
    if (1==1) {
      syncBarrier.enroll();
      processes.addProcess(() -> {
        CSTimer timer = new CSTimer();
        while (true) {
          timer.sleep(500);
          syncBarrier.sync();
        }
      });
    }

    processes.run();
  }
}
