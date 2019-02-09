/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code.argument;

import com.erhannis.exasystem.Constants;
import lombok.Data;

/**
 *
 * @author erhannis
 */
@Data
public class ExaNumber implements ExaValue, ExaValuedArgument {
  public final int value;
  
  public ExaNumber(int value) {
    value = Math.max(Constants.MIN_INT, value);
    value = Math.min(Constants.MAX_INT, value);
    this.value = value;
  }
}
