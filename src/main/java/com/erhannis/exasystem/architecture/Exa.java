/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.architecture;

import com.erhannis.exasystem.code.Instruction;
import com.erhannis.exasystem.code.argument.ExaNumber;
import com.erhannis.exasystem.code.argument.ExaValue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jcsp.lang.Barrier;
import jcsp.lang.CSProcess;
import jcsp.lang.CSTimer;
import lombok.Data;

/**
 *
 * @author erhannis
 */
public class Exa implements CSProcess {
  private final Barrier syncBarrier;

  public final String name;
  public ExaValue x = new ExaNumber(0);
  public ExaValue t = new ExaNumber(0);
  public ExaFile file;
  public String sourceCode;
  public final List<Instruction> code;
  public int instructionPointer = 0;
  public int dataPointer = 0;

  public Exa(Barrier syncBarrier, String name, List<Instruction> code) {
    this.syncBarrier = syncBarrier;
    syncBarrier.enroll();

    this.name = name;
    this.code = code; //TODO Copy?
  }

  @Override
  public void run() {
    try {
      CSTimer timer = new CSTimer();
      while (true) {
        System.out.println("EXA (" + name + ") - step");
        //TODO Do
        syncBarrier.sync();
      }
    } finally {
      syncBarrier.resign();
    }
  }
}
