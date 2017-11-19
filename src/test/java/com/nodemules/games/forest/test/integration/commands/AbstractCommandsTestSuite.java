package com.nodemules.games.forest.test.integration.commands;

import com.nodemules.games.forest.ForestGameApplication;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.Shell;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
@ActiveProfiles("test")
@ContextConfiguration(classes = {ForestGameApplication.class})
@SpringBootTest
public abstract class AbstractCommandsTestSuite extends AbstractJUnit4SpringContextTests {

  protected Map<String, MethodTarget> commands;

  @Autowired
  protected Shell shell;

  @Before
  public void getShellCommands() {
    log.info("Getting shell commands");
    commands = shell.listCommands();
    log.info("{} shell commands found", commands.entrySet().size());
  }

  @After
  public void after() {
    log.info("After");
  }

}
