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

  @Test
  public void testItemList() throws Exception {
    List<String> r = execute("item list");
    Assert.assertTrue(r.size() == 2);
  }

  @Test
  public void testItemMake() throws Exception {
    String name = "toast";
    String message = execute(String.format("item make %s", name));
    Assert.assertEquals(String.format("Item `%s` created!", name), message);
  }

}
