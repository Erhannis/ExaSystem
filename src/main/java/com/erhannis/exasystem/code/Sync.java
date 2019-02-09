/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code;

import com.erhannis.exasystem.architecture.Exa;
import lombok.Data;

/**
 * Specific to the TEC RedShift
 *
 * @author erhannis
 */
@Data
public class Sync implements Instruction {

  @Override
  public Result execute(Exa exa) {
    //TODO
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
