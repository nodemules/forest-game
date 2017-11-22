package com.nodemules.games.forest.test.integration.commands;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author brent
 * @since 11/19/17.
 */
@Slf4j
public class RegisterCommandsTest extends AbstractCommandsTestSuite {

  private static final String USERNAME_AVAILABLE = "foo";
  private static final String USERNAME_TAKEN = "LIAM_NEESON";

  private static final String COMMAND_REGISTER = "user register";

  @Test
  public void testRegister() {
    String s = execute(formatCommand(COMMAND_REGISTER, USERNAME_AVAILABLE, "bar"));
    Assert.assertTrue(String.format("Registered %s!", USERNAME_AVAILABLE).equals(s));
  }

  @Test
  public void testRegister_usernameTaken() {
    String s = execute(formatCommand(COMMAND_REGISTER, USERNAME_TAKEN, "bar"));
    Assert.assertEquals("Username is unavailable", s);
  }

}
