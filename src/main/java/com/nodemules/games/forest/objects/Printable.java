package com.nodemules.games.forest.objects;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author brent
 * @since 11/19/17.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Printable extends Named implements Serializable {

  private static final long serialVersionUID = 9075887864548543609L;

  // @formatter:off
  private static final String ITEM_TEMPLATE = "======================================\n"
                                            + "=                                    =\n"
                                            + "=              Name:                 =\n"
                                            + "=              %-10s                 =\n"
                                            + "=                                    =\n"
                                            + "=                                    =\n"
                                            + "======================================";
  // @formatter:on

  public void print() {
    System.out.println(String.format(ITEM_TEMPLATE, name));
  }

}

