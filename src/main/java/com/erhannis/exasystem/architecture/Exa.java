/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.architecture;

import com.erhannis.exasystem.code.Instruction;
import com.erhannis.exasystem.code.argument.ExaNumber;
import com.erhannis.exasystem.code.argument.ExaValue;
import com.erhannis.exasystem.code.errors.ExaException;
import com.erhannis.exasystem.code.errors.NoMoreInstructionsException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jcsp.lang.Barrier;
import jcsp.lang.CSProcess;
import jcsp.lang.CSTimer;

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
  public boolean localMode = false;
  public String sourceCode;
  public final List<Instruction> code;
  public final Map<String, Integer> labels;
  public int instructionPointer = 0;
  public int dataPointer = 0;
  
  // Generic object an instruction can use to track multi-cycle state
  public Object instructionState;

  public Exa(Barrier syncBarrier, String name, List<Instruction> code) {
    this(syncBarrier, name, code, new HashMap<String, Integer>());
  }

  public Exa(Barrier syncBarrier, String name, List<Instruction> code, Map<String, Integer> labels) {
    this.syncBarrier = syncBarrier;
    syncBarrier.enroll();

    this.name = name;
    this.code = code; //TODO Copy?
    if (labels == null) {
      labels = new HashMap<String, Integer>();
    }
    this.labels = labels;
  }

  @Override
  public void run() {
    try {
      CSTimer timer = new CSTimer();
      while (true) {
        System.out.println("EXA (" + name + ") - step [x:" + x + ", t:" + t + ", mode:" + (localMode ? "local" : "global") + "]");
        
        if (instructionPointer >= code.size()) {
          throw new NoMoreInstructionsException();
        }
        
        switch (code.get(instructionPointer).execute(this)) {
          case NOT_DONE:
            break;
          case DONE:
            instructionPointer++;
          case DONE_DONT_INCREMENT_POINTER:
            instructionState = null;
            break;
        }
        
        syncBarrier.sync();
      }
    } catch (ExaException e) {
      System.err.println("EXA (" + name + ") - ERROR");
      e.printStackTrace();
    } finally {
      syncBarrier.resign();
    }
  }
}
