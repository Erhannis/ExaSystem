/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code;

import com.erhannis.exasystem.architecture.registers.Register;
import lombok.Data;
import com.erhannis.exasystem.code.argument.ExaValuedArgument;

/**
 *
 * @author erhannis
 */
@Data
public class Swiz implements Instruction {
  public final ExaValuedArgument a;
  public final ExaValuedArgument b;
  public final Register c;
}
