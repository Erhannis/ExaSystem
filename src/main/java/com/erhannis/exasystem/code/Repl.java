/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code;

import lombok.Data;
import com.erhannis.exasystem.code.argument.Label;

/**
 *
 * @author erhannis
 */
@Data
public class Repl implements Instruction {
  public final Label a;
}
