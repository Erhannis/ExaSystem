/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code;

import com.erhannis.exasystem.architecture.Exa;
import com.erhannis.exasystem.architecture.registers.BuiltInRegisters;
import com.erhannis.exasystem.architecture.registers.HardwareRegisterReference;
import com.erhannis.exasystem.architecture.registers.Register;
import com.erhannis.exasystem.code.argument.ExaNumber;
import lombok.Data;
import com.erhannis.exasystem.code.argument.ExaValuedArgument;
import com.erhannis.exasystem.code.errors.NumericValueRequredException;

/**
 *
 * @author erhannis
 */
@Data
public class Copy implements Instruction {
  public final ExaValuedArgument a;
  public final Register b;

  @Override
  public Result execute(Exa exa) throws NumericValueRequredException {
    ExaNumber va;
    
    if (a instanceof ExaNumber) {
      va = (ExaNumber)a;
    } else if (a instanceof BuiltInRegisters) {
      //TODO Not sure if should stay here, or move to (BuiltInRegisters).getRegister(Exa), or move to (Exa).getRegister(BuiltInRegister)
      switch ((BuiltInRegisters)a) {
        case X:
          va = exa.x.getNumber();
          break;
        case T:
          va = exa.t.getNumber();
          break;
        case F:
          throw new UnsupportedOperationException("Not supported yet.");
        case M:
          throw new UnsupportedOperationException("Not supported yet.");
        default:
          throw new RuntimeException("WTF");
      }
    } else if (a instanceof HardwareRegisterReference) {
      throw new UnsupportedOperationException("Not supported yet.");
    } else {
      throw new RuntimeException("WTF");
    }
    
    if (b instanceof BuiltInRegisters) {
      //TODO Not sure if should stay here, or move to (BuiltInRegisters).getRegister(Exa), or move to (Exa).getRegister(BuiltInRegister)
      switch ((BuiltInRegisters)b) {
        case X:
          exa.x = va;
          break;
        case T:
          exa.t = va;
          break;
        case F:
          throw new UnsupportedOperationException("Not supported yet.");
        case M:
          throw new UnsupportedOperationException("Not supported yet.");
      }
    } else if (b instanceof HardwareRegisterReference) {
      throw new UnsupportedOperationException("Not supported yet.");
    }
    
    return Result.DONE;
  }
}
