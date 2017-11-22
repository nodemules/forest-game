package com.nodemules.games.forest.model;

import lombok.Data;

/**
 * @author brent
 * @since 11/19/17.
 */
@Data
public class CommandModel {

  private Long id;

  private String key;

  private String name;
  private String description;

}
