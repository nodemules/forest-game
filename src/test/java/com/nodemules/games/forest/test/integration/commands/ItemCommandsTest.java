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
  public void test() throws Exception {
    List<String> r = execute("item list");
    Assert.assertTrue(r.size() == 2);
  }

}
