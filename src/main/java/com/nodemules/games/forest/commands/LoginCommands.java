package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.service.AuthenticationOperations;
import com.nodemules.games.forest.service.AuthenticationService;
import com.nodemules.games.forest.service.LoginOperations;
import com.nodemules.games.forest.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
@ShellComponent
public class LoginCommands {

  private LoginOperations loginService;

  private AuthenticationOperations authService;

  @Autowired
  public LoginCommands(LoginService loginService, AuthenticationService authService) {
    this.loginService = loginService;
    this.authService = authService;
  }

  public Availability loginAvailability() {
    if (authService.isUserLoggedIn()) {
      return Availability.unavailable("it is not available to users who are not logged in");
    }
    return Availability.available();
  }

  @ShellMethod(value = "Logs a user into the system", key = "user login")
  public boolean login(String username, String password) {
    try {
      loginService.login(username, password);
    } catch (AuthenticationException e) {
      log.error("ERROR: INVALID LOGIN");
      log.trace("TRACE:", e);
      return false;
    }
    return true;
  }

  public Availability logoutAvailability() {
    if (authService.isUserLoggedIn()) {
      return Availability.available();
    }
    return Availability.unavailable("it is not available to users who are not logged in");
  }

  @ShellMethod(value = "Logs out the current authenticated user", key = "user logout")
  public boolean logout() {
    try {
      loginService.logout();
    } catch (AuthenticationException e) {
      log.error("ERROR: UNABLE TO LOGOUT");
      log.trace("TRACE:", e);
      return false;
    }
    return true;
  }

}
