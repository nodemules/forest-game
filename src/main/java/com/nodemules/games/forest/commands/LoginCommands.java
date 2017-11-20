package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.service.LoginOperations;
import com.nodemules.games.forest.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  public LoginCommands(LoginService loginService) {
    this.loginService = loginService;
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

}
