package com.nodemules.games.forest.service;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.objects.User;

/**
 * @author brent
 * @since 11/18/17.
 */
public interface AuthenticationOperations {

  User whoami() throws AuthenticationException;

  boolean isUserLoggedIn();
}
