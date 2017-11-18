package com.nodemules.games.forest.objects;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author brent
 * @since 11/18/17.
 */
@Data
public class User implements Serializable {

  private static final long serialVersionUID = 8825528582019267766L;

  private String username;

  private Date dateCreated;
  private Date dateModified;

}
