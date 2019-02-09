/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.architecture;

import java.util.ArrayList;

/**
 *
 * @author erhannis
 */
public class ExaHost {
  public ArrayList<Exa> exas = new ArrayList<>();
  public ArrayList<ExaFile> files = new ArrayList<>();
  public ArrayList<ExaLink> links = new ArrayList<>();
  public ArrayList<HardwareRegister> registers = new ArrayList<>();
}
