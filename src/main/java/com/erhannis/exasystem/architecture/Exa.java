/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.architecture;

import com.erhannis.exasystem.code.Instruction;
import com.erhannis.exasystem.code.argument.ExaNumber;
import com.erhannis.exasystem.code.argument.ExaValue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

/**
 *
 * @author erhannis
 */
@Data
public class Exa {
    public final String id;
    public ExaValue x = new ExaNumber(0);
    public ExaValue t = new ExaNumber(0);
    public ExaFile file;
    public String sourceCode;
    public final List<Instruction> code;
    public int instructionPointer = 0;
    public int dataPointer = 0;
}
