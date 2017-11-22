package com.nodemules.games.forest.test.integration.commands;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author brent
 * @since 11/19/17.
 */
@Slf4j
public class LoginCommandsTest extends AbstractCommandsTestSuite {

  private static final String USER_USERNAME = "TEST_USERNAME";
  private static final String USER_PASSWORD = "TEST_PASSWORD";

  private static final String COMMAND_LOGIN = "user login";

  @Test
  public void testLogin() {
    boolean result = execute(formatCommand(COMMAND_LOGIN, USER_USERNAME, USER_PASSWORD));
    Assert.assertTrue(result);
  }

  @Test
  public void testLogin_invalidPassword() {
    boolean result = execute(formatCommand(COMMAND_LOGIN, USER_USERNAME, "BAD_PASSWORD"));
    Assert.assertTrue(!result);
  }

}
