/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code.argument;

import com.erhannis.exasystem.code.errors.NumericValueRequredException;

/**
 *
 * @author erhannis
 */
public interface ExaValue {
  /**
   * Default implementation returns an ExaNumber iff `this` is an ExaNumber, otherwise throws NumericValueRequredException
   * @return 
   */
  public default ExaNumber getNumber() throws NumericValueRequredException {
    if (this instanceof ExaNumber) {
      return (ExaNumber)this;
    } else {
      throw new NumericValueRequredException();
    }
  }
}
