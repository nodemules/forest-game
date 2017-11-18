package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.objects.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author brent
 * @since 11/17/17.
 */
@Slf4j
@ShellComponent
public class ItemCommands {

  @ShellMethod("Makes an item")
  public String makeItem(
      @ShellOption(help = "The name of the command (defaults to null)", defaultValue = "") String name,
      @ShellOption(help = "The description of the command (defaults to null)", defaultValue = "") String description) {
    return null;
  }

  @ShellMethod("Prints an item")
  public void print(String name) {
    Item item = new Item();
    item.setName(name);
    item.print();
  }

}
