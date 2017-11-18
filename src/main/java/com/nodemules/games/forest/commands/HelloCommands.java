package com.nodemules.games.forest.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author brent
 * @since 11/16/17.
 */
@ShellComponent
public class HelloCommands {

  @ShellMethod("Says hello")
  public String hello() {
    return "Hello world";
  }

  @ShellMethod("Says goodbye")
  public String goodbye() {
    return "Goodbye cruel world";
  }

  @ShellMethod("Prints a giant hello world")
  public void giantHelloWorld() {

    String asciiHelloWorld = "\n"
        + "          _______  _        _        _______ \n"
        + "|\\     /|(  ____ \\( \\      ( \\      (  ___  )\n"
        + "| )   ( || (    \\/| (      | (      | (   ) |\n"
        + "| (___) || (__    | |      | |      | |   | |\n"
        + "|  ___  ||  __)   | |      | |      | |   | |\n"
        + "| (   ) || (      | |      | |      | |   | |\n"
        + "| )   ( || (____/\\| (____/\\| (____/\\| (___) |\n"
        + "|/     \\|(_______/(_______/(_______/(_______)\n"
        + "                                             \n"
        + "          _______  _______  _        ______  \n"
        + "|\\     /|(  ___  )(  ____ )( \\      (  __  \\ \n"
        + "| )   ( || (   ) || (    )|| (      | (  \\  )\n"
        + "| | _ | || |   | || (____)|| |      | |   ) |\n"
        + "| |( )| || |   | ||     __)| |      | |   | |\n"
        + "| || || || |   | || (\\ (   | |      | |   ) |\n"
        + "| () () || (___) || ) \\ \\__| (____/\\| (__/  )\n"
        + "(_______)(_______)|/   \\__/(_______/(______/ ";

    System.out.println(asciiHelloWorld);

  }

}
