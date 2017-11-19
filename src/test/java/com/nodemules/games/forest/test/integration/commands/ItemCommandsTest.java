package com.nodemules.games.forest.test.integration.commands;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
public class ItemCommandsTest extends AbstractCommandsTestSuite {

  private static final String TEST_ITEM_NAME = "toast";

  @Test
  public void testItemPrint() throws Exception {
    execute(formatCommand("item print", TEST_ITEM_NAME));
  }

  @Test
  public void testItemList() throws Exception {
    List<String> r = execute("item list");
    Assert.assertTrue(r.size() == 2);
  }

  @Test
  public void testItemMake() throws Exception {
    String message = execute(formatCommand("item make", TEST_ITEM_NAME));
    Assert.assertEquals(String.format("Item `%s` created!", TEST_ITEM_NAME), message);
  }

}
