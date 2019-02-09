/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code;

import com.erhannis.exasystem.architecture.Exa;
import com.erhannis.exasystem.code.errors.ExaException;

/**
 *
 * @author erhannis
 */
public interface Instruction {
  public static enum Result {
    DONE, DONE_DONT_INCREMENT_POINTER, NOT_DONE;
  }
  
  public Result execute(Exa exa) throws ExaException;
}
