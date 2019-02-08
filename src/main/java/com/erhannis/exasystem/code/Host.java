/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code;

import com.erhannis.exasystem.architecture.registers.Register;
import com.erhannis.exasystem.code.argument.ExaValuedArgument;
import lombok.Data;

/**
 *
 * @author erhannis
 */
@Data
public class Host implements Instruction {
  public final Register a;
}
