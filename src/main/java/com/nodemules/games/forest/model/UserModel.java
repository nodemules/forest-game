package com.nodemules.games.forest.model;

import java.util.Date;
import lombok.Data;

/**
 * @author brent
 * @since 11/18/17.
 */
@Data
public class UserModel {

  private Long id;
  private String username;

  private String password;

  private String email;

  private Date dateCreated;
  private Date dateModified;

}
