package com.nodemules.games.forest.test.integration.commands;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author brent
 * @since 11/19/17.
 */
public class CommandCommandsTest extends AbstractCommandsTestSuite {

  private static final int EXPECTED_COMMAND_LIST_SIZE = 2;

  private static final String TEST_COMMAND_NAME = "bewilder";

  private static final String COMMAND_COMMAND_MAKE = "command make";
  private static final String COMMAND_COMMAND_LIST = "command list";


  @Test
  public void testCommandList() throws Exception {
    List<String> r = execute(COMMAND_COMMAND_LIST);
    Assert.assertEquals(EXPECTED_COMMAND_LIST_SIZE, r.size());
  }

  @Test
  public void testCommandMake() throws Exception {
    String message = execute(formatCommand(COMMAND_COMMAND_MAKE, TEST_COMMAND_NAME));
    Assert.assertEquals(String.format("Command `%s` created!", TEST_COMMAND_NAME), message);
  }

}
