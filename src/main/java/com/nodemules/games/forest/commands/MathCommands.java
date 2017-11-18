package com.nodemules.games.forest.commands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author brent
 * @since 11/16/17.
 */
@Slf4j
@ShellComponent
public class MathCommands {

  @ShellMethod("Adds two integers")
  public int add(int a, int b) {
    log.info("Adding a:{} and b:{}", a, b);
    return a + b;
  }

  @ShellMethod("Squares an integer")
  public long square(int a) {
    return (long) Math.pow(a, 2);
  }

}
