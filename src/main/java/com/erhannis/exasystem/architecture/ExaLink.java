/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhannis.exasystem.architecture;

import com.erhannis.exasystem.code.argument.ExaNumber;
import lombok.Data;

/**
 *
 * @author erhannis
 */
@Data
public class ExaLink {
  public final ExaNumber id;
  //TODO Note that if a host goes away, the link needs to go away, too.  And I don't know how.
  //TODO Note also that I'm not sure what to do in the case of remote hosts.
  public final ExaHost target;
}
