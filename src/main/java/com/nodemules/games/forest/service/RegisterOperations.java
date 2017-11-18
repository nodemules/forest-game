package com.nodemules.games.forest.service;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.model.UserModel;

/**
 * @author brent
 * @since 11/18/17.
 */
public interface RegisterOperations {

  /**
   * Registers a user
   *
   * @param username
   * @param password
   * @param email
   */
  void register(String username, String password, String email) throws AuthenticationException;

  /**
   * Registers a user
   *
   * @param user
   */
  void register(UserModel user) throws AuthenticationException;
}
