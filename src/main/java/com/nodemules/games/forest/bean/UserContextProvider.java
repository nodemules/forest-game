package com.nodemules.games.forest.bean;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
@Component
public class UserContextProvider {

  private UserContext userContext;

  @PostConstruct
  public void postConstruct() {
    log.info("UserContextProvider.@PostConstruct");
    userContext = new UserContext();
  }

  @Bean
  public UserContext userContext() {
    return userContext;
  }

}
