/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code;

import com.erhannis.exasystem.architecture.Exa;
import com.erhannis.exasystem.architecture.registers.Register;
import lombok.Data;
import com.erhannis.exasystem.code.argument.ExaValuedArgument;
import com.erhannis.exasystem.code.argument.Label;

/**
 *
 * @author erhannis
 */
@Data
public class Jump implements Instruction {
  public final Label a;

  @Override
  public Result execute(Exa exa) {
    //TODO Check null/bounds?
    exa.instructionPointer = exa.labels.get(a.label);
    return Result.DONE_DONT_INCREMENT_POINTER;
  }
}
