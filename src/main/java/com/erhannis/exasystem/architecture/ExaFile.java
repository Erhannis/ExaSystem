/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.architecture;

import com.erhannis.exasystem.code.argument.ExaNumber;
import com.erhannis.exasystem.code.argument.ExaValue;
import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author erhannis
 */
@Data
public class ExaFile {
  public final ExaNumber id;
  public ArrayList<ExaValue> data = new ArrayList<>();
}
