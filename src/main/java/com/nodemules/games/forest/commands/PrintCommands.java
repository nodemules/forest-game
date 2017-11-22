package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.objects.Command;
import com.nodemules.games.forest.objects.Item;
import com.nodemules.games.forest.service.CommandOperations;
import com.nodemules.games.forest.service.CommandService;
import com.nodemules.games.forest.service.ItemOperations;
import com.nodemules.games.forest.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author brent
 * @since 11/19/17.
 */
@Slf4j
@ShellComponent
public class PrintCommands {

  private ItemOperations itemService;
  private CommandOperations commandService;

  public PrintCommands(CommandService commandService, ItemService itemService) {
    this.commandService = commandService;
    this.itemService = itemService;
  }

  @ShellMethod(value = "Prints a command", key = "print command")
  public void printCommand(@ShellOption(help = "The command key") String key) {
    Command command = commandService.getCommand(key);

    command.print();
  }

  @ShellMethod(value = "Prints an item", key = "print item")
  public void printItem(String name) {
    Item item = itemService.getItem(name);

    item.print();
  }

}
