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
public class Addi implements Instruction {
  public final ExaValuedArgument a;
  public final ExaValuedArgument b;
  public final Register c;

  @Override
  public Result execute(Exa exa) throws NumericValueRequredException {
    ExaNumber va, vb;
    
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

    //TODO Can this block be extracted?
    if (b instanceof ExaNumber) {
      vb = (ExaNumber)b;
    } else if (b instanceof BuiltInRegisters) {
      //TODO Not sure if should stay here, or move to (BuiltInRegisters).getRegister(Exa), or move to (Exa).getRegister(BuiltInRegister)
      switch ((BuiltInRegisters)b) {
        case X:
          vb = exa.x.getNumber();
          break;
        case T:
          vb = exa.t.getNumber();
          break;
        case F:
          throw new UnsupportedOperationException("Not supported yet.");
        case M:
          throw new UnsupportedOperationException("Not supported yet.");
        default:
          throw new RuntimeException("WTF");
      }
    } else if (b instanceof HardwareRegisterReference) {
      throw new UnsupportedOperationException("Not supported yet.");
    } else {
      throw new RuntimeException("WTF");
    }
    
    if (c instanceof BuiltInRegisters) {
      //TODO Not sure if should stay here, or move to (BuiltInRegisters).getRegister(Exa), or move to (Exa).getRegister(BuiltInRegister)
      switch ((BuiltInRegisters)c) {
        case X:
          exa.x = new ExaNumber(va.value + vb.value);
          break;
        case T:
          exa.t = new ExaNumber(va.value + vb.value);
          break;
        case F:
          throw new UnsupportedOperationException("Not supported yet.");
        case M:
          throw new UnsupportedOperationException("Not supported yet.");
      }
    } else if (c instanceof HardwareRegisterReference) {
      throw new UnsupportedOperationException("Not supported yet.");
    }
    
    return Result.DONE;
  }
}
