package com.nodemules.games.forest.orm.manager;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.model.UserModel;

/**
 * @author brent
 * @since 11/18/17.
 */
public interface UserManagement {

  /**
   * Creates a user
   *
   * @param user
   * @throws AuthenticationException
   */
  void create(UserModel user) throws AuthenticationException;

  UserModel findByUsername(String username);

  UserModel loginUser(String username, String password) throws AuthenticationException;

  UserModel loginUser(UserModel user) throws AuthenticationException;
}
