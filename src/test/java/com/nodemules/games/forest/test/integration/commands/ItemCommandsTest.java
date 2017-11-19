package com.nodemules.games.forest.test.integration.commands;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
@ActiveProfiles("item")
public class ItemCommandsTest extends AbstractCommandsTestSuite {

  @Test
  public void test() throws Exception {
    Object r = shell.evaluate(() -> "item list");
    log.info("item list is: {}", r);
    Assert.fail();
  }

}
