package com.nodemules.games.forest.objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author brent
 * @since 11/17/17.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Item extends Printable {

  private static final long serialVersionUID = -2152948617329560906L;

  private String description;

}
