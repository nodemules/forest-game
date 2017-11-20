package com.nodemules.games.forest.commands.util;

import com.nodemules.games.forest.service.AuthenticationOperations;
import com.nodemules.games.forest.service.AuthenticationService;
import com.nodemules.games.forest.util.EncryptionUtil;
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
public class CryptoCommands {

  private AuthenticationOperations authService;

  @Autowired
  public CryptoCommands(AuthenticationService authService) {
    this.authService = authService;
  }

  public Availability encryptAvailability() {
    if (authService.isUserLoggedIn()) {
      return Availability.available();
    }
    return Availability.unavailable("requires a login");
  }

  @ShellMethod(value = "Encrypts the given string", key = "crypto encrypt")
  public String encrypt(String value) {
    return EncryptionUtil.encrypt(value);
  }

}
