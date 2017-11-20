package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.objects.User;
import com.nodemules.games.forest.service.AuthenticationOperations;
import com.nodemules.games.forest.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author brent
 * @since 11/19/17.
 */
@Slf4j
@ShellComponent
public class UserCommands {

  private AuthenticationOperations authService;

  @Autowired
  public UserCommands(AuthenticationService authService) {
    this.authService = authService;
  }

  public Availability whoamiAvailability() {
    if (authService.isUserLoggedIn()) {
      return Availability.available();
    }
    return Availability.unavailable("it is not available to users who are not logged in");
  }

  @ShellMethod(value = "Tells you who is logged into the system", key = "user whoami")
  public String whoami() {
    User user;
    try {
      user = authService.whoami();
    } catch (AuthenticationException e) {
      log.trace("UserCommands.whoami()", e);
      return e.getMessage();
    }
    return user.getUsername();
  }

}
