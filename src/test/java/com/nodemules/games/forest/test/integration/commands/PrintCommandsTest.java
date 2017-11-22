package com.nodemules.games.forest.test.integration.commands;

import org.junit.Test;

/**
 * @author brent
 * @since 11/19/17.
 */
public class PrintCommandsTest extends AbstractCommandsTestSuite {

  private static final String COMMAND_PRINT_ITEM = "print item";
  private static final String COMMAND_PRINT_COMMAND = "print command";

  private static final String TEST_ITEM_NAME = "toast";
  private static final String TEST_COMMAND_NAME = "bamboozle";


  @Test
  public void testPrintItem() throws Exception {
    execute(formatCommand(COMMAND_PRINT_ITEM, TEST_ITEM_NAME));
  }

  @Test
  public void testPrintCommand() throws Exception {
    execute(formatCommand(COMMAND_PRINT_COMMAND, TEST_COMMAND_NAME));
  }

}
