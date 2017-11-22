package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.objects.Command;
import com.nodemules.games.forest.service.CommandOperations;
import com.nodemules.games.forest.service.CommandService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author brent
 * @since 11/17/17.
 */
@Slf4j
@ShellComponent
public class CommandCommands {

  private CommandOperations commandService;

  @Autowired
  public CommandCommands(CommandService commandService) {
    this.commandService = commandService;
  }

  @ShellMethod(value = "Makes a new command", key = "command make")
  public String makeCommand(
      @ShellOption(help = "The command key") String key,
      @ShellOption(help = "The name of the command (defaults to null)", defaultValue = ShellOption.NULL) String name,
      @ShellOption(help = "The description of the command (defaults to null)", defaultValue = ShellOption.NULL) String description
  ) {
    commandService.create(key, name, description);
    return String.format("Command `%s` created!", key);
  }

  @ShellMethod(value = "Lists commands", key = "command list")
  public List<String> listCommands() {
    List<Command> commands = commandService.getCommands();

    log.info("{} commands found", commands.size());

    return commands.stream().map(Command::getKey).collect(Collectors.toList());
  }

}
