package com.nodemules.games.forest.bean;

import com.nodemules.games.forest.model.UserModel;
import lombok.Data;

/**
 * @author brent
 * @since 11/18/17.
 */
@Data
public class UserContext {

  private UserModel currentUser;

  public boolean isUserLoggedIn() {
    return currentUser != null;
  }
}
