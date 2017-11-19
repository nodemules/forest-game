package com.nodemules.games.forest.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
@Component
@Profile("test")
public class TestApplicationRunner implements ApplicationRunner {

  public TestApplicationRunner() {
    log.info("Intializing TestApplicationRunner");
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("TestApplicationRunner::run");
    log.info("ApplicationArguments", args);
  }


}
