package com.nodemules.games.forest.test.integration.commands;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.service.LoginService;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author brent
 * @since 11/19/17.
 */
public abstract class AbstractAuthenticatedTestSuite extends AbstractCommandsTestSuite {

  protected static final String USER_USERNAME = "TEST_USERNAME";
  protected static final String USER_PASSWORD = "TEST_PASSWORD";

  @Autowired
  private LoginService loginService;

  @Before
  public void login() throws AuthenticationException {
    loginService.login(USER_USERNAME, USER_PASSWORD);
  }

  @After
  public void logout() throws AuthenticationException {
    loginService.logout();
  }
}
