package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.objects.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author brent
 * @since 11/17/17.
 */
@Slf4j
@ShellComponent
public class ItemCommands {

  @ShellMethod("Prints an item")
  public void print(String name) {
    Item item = new Item();
    item.setName(name);
    item.print();
  }

}
