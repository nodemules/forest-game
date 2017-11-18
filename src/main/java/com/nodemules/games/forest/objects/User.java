package com.nodemules.games.forest.objects;

import java.util.Date;
import lombok.Data;

/**
 * @author brent
 * @since 11/18/17.
 */
@Data
public class User {

  private String username;

  private Date dateCreated;
  private Date dateModified;

}
