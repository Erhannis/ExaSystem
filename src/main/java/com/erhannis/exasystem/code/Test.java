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
import com.erhannis.exasystem.code.argument.TestOperator;
import com.erhannis.exasystem.code.errors.ExaException;

/**
 *
 * @author erhannis
 */
@Data
public class Test implements Instruction {
  public final ExaValuedArgument a;
  public final TestOperator b;
  public final ExaValuedArgument c;

  @Override
  public Result execute(Exa exa) throws ExaException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
