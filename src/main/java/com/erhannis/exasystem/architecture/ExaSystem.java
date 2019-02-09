/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.architecture;

import java.util.ArrayList;
import jcsp.lang.AltingBarrier;
import jcsp.lang.Barrier;
import jcsp.lang.CSProcess;
import jcsp.lang.CSTimer;

/**
 *
 * @author erhannis
 */
public class ExaSystem implements CSProcess {
  private final Barrier syncBarrier;

  public ArrayList<ExaHost> hosts = new ArrayList<>();

  public ExaSystem(Barrier syncBarrier) {
    this.syncBarrier = syncBarrier;
    syncBarrier.enroll();
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
