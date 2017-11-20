package com.nodemules.games.forest.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author brent
 * @since 11/19/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Named {

  protected String name;

}
