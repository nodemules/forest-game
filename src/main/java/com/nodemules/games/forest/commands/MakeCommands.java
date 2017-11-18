package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.exception.InvalidInputException;
import com.nodemules.games.forest.orm.domain.Command;
import com.nodemules.games.forest.orm.repository.CommandRepository;
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
public class MakeCommands {

  private CommandRepository commandRepo;

  @Autowired
  public MakeCommands(CommandRepository commandRepo) {
    this.commandRepo = commandRepo;
  }

  @ShellMethod(value = "Makes a new command", key = "command make")
  public String makeCommand(
      @ShellOption(help = "The command key") String key,
      @ShellOption(help = "The name of the command (defaults to null)", defaultValue = ShellOption.NULL) String name,
      @ShellOption(help = "The description of the command (defaults to null)", defaultValue = ShellOption.NULL) String description
  ) {
    if (key == null) {
      throw new InvalidInputException("A key is required to make a command");
    }
    Command c = new Command();
    c.setValue(key);
    c.setName(name);
    c.setDescription(description);
    commandRepo.save(c);
    return String.format("Command `%s` created!", key);
  }

  @ShellMethod(value = "Lists commands", key = "command list")
  public List<String> listCommands() {
    List<Command> commands = commandRepo.findAll();

    log.info("{} commands found", commands.size());

    return commands.stream().map(Command::getValue).collect(Collectors.toList());
  }

}
