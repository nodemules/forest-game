package com.nodemules.games.forest.objects;

import lombok.Data;

/**
 * @author brent
 * @since 11/17/17.
 */
@Data
public class Item {

  // @formatter:off
  private static final String ITEM_TEMPLATE = "======================================\n"
                                            + "=                                    =\n"
                                            + "=              Name:                 =\n"
                                            + "=               %s                   =\n"
                                            + "=                                    =\n"
                                            + "=                                    =\n"
                                            + "======================================";
  // @formatter:on

  private String name;
  private String description;

  public void print() {
    System.out.println(String.format(ITEM_TEMPLATE, name));
  }

}
