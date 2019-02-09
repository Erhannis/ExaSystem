/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.architecture;

import java.util.ArrayList;
import jcsp.lang.Barrier;
import jcsp.lang.CSProcess;
import jcsp.lang.CSTimer;

/**
 *
 * @author erhannis
 */
public class ExaHost implements CSProcess {
  private final Barrier syncBarrier;

  public final String name;

  public final int capacity;

  public ArrayList<Exa> exas = new ArrayList<>();
  public ArrayList<ExaFile> files = new ArrayList<>();
  public ArrayList<ExaLink> links = new ArrayList<>();
  public ArrayList<HardwareRegister> registers = new ArrayList<>();

  public ExaHost(Barrier syncBarrier, String name, int capacity) {
    this.syncBarrier = syncBarrier;
    syncBarrier.enroll();

    this.name = name;
    this.capacity = capacity;
  }

  @Override
  public void run() {
    try {
      CSTimer timer = new CSTimer();
      while (true) {
        //TODO Is there actually anything to do?
        syncBarrier.sync();
      }
    } finally {
      syncBarrier.resign();
    }
  }
}
