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

  @ShellMethod("Makes a new command")
  public String makeCommand(String value, @ShellOption(defaultValue = "") String name,
      @ShellOption(defaultValue = "") String description) {
    if (value == null) {
      throw new InvalidInputException("A value is required to make a command");
    }
    Command c = new Command();
    c.setValue(value);
    c.setName(name);
    c.setDescription(description);
    commandRepo.save(c);
    return String.format("Command `%s` created!", value);
  }

  @ShellMethod("Lists commands")
  public List<String> listCommands() {
    List<Command> commands = commandRepo.findAll();

    log.info("{} commands found", commands.size());

    return commands.stream().map(Command::getValue).collect(Collectors.toList());
  }

}
