/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code;

import com.erhannis.exasystem.code.argument.ExaValuedArgument;
import lombok.Data;

/**
 *
 * @author erhannis
 */
@Data
public class Grab implements Instruction {
  public final ExaValuedArgument a;
}
