/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.code;

import com.erhannis.exasystem.architecture.ExaFile;

/**
 * Specific to the TEC RedShift
 *
 * @author erhannis
 */
@lombok.Data
public class Data implements Instruction {
  public final ExaFile a;
}
