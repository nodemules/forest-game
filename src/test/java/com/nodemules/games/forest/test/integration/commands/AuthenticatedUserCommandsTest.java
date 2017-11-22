package com.nodemules.games.forest.test.integration.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author brent
 * @since 11/19/17.
 */
public class AuthenticatedUserCommandsTest extends AbstractAuthenticatedTestSuite {

  private static final String COMMAND_WHOAMI = "user whoami";

  @Test
  public void testWhoami() {
    String result = execute(COMMAND_WHOAMI);
    Assert.assertEquals(USER_USERNAME, result);
  }

}
