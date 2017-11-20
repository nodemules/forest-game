package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.service.RegisterOperations;
import com.nodemules.games.forest.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
@ShellComponent
public class RegisterCommands {

  private RegisterOperations registerService;

  @Autowired
  public RegisterCommands(RegisterService registerService) {
    this.registerService = registerService;
  }

  @ShellMethod(value = "Registers a user", key = "user register")
  public String register(
      @ShellOption(help = "A unique username") String username,
      @ShellOption(help = "The password for the new User") String password,
      @ShellOption(defaultValue = ShellOption.NULL) String email) {
    try {
      registerService.register(username, password, email);
    } catch (AuthenticationException e) {
      log.trace("TRACE:", e);
      return e.getMessage();
    }
    return String.format("Registered %s!", username);
  }

}
