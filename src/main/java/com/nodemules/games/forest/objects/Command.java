package com.nodemules.games.forest.objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author brent
 * @since 11/19/17.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Command extends Printable {

  private static final long serialVersionUID = -6327559867510923325L;
  private String key;

  private String description;

}

