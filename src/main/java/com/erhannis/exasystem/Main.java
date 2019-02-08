/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem;

import com.erhannis.exasystem.architecture.Exa;
import com.erhannis.exasystem.architecture.registers.BuiltInRegisters;
import com.erhannis.exasystem.code.Addi;
import com.erhannis.exasystem.code.Copy;
import com.erhannis.exasystem.code.Instruction;
import com.erhannis.exasystem.code.Jump;
import com.erhannis.exasystem.code.Mark;
import com.erhannis.exasystem.code.argument.ExaNumber;
import com.erhannis.exasystem.code.argument.Label;
import java.util.ArrayList;

/**
 *
 * @author erhannis
 */
public class Main {
  public static void main(String[] args) {
    test();
  }
  
  public static void test() {
    Exa xa = new Exa();
    ArrayList<Instruction> code = new ArrayList<>();
    code.add(new Copy(new ExaNumber(0), BuiltInRegisters.X));
    code.add(new Mark(new Label("LOOP")));
    code.add(new Addi(BuiltInRegisters.X, new ExaNumber(1), BuiltInRegisters.X));
    code.add(new Jump(new Label("LOOP")));
  }
}
