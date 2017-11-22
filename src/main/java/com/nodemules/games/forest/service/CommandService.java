package com.nodemules.games.forest.service;

import com.nodemules.games.forest.mapper.CommandMapper;
import com.nodemules.games.forest.model.CommandModel;
import com.nodemules.games.forest.objects.Command;
import com.nodemules.games.forest.orm.manager.CommandManagement;
import com.nodemules.games.forest.orm.manager.CommandManager;
import fr.xebia.extras.selma.Selma;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author brent
 * @since 11/19/17.
 */
@Service
public class CommandService implements CommandOperations {

  private CommandManagement commandManager;

  private static CommandMapper commandMapper = Selma.builder(CommandMapper.class).build();

  @Autowired
  public CommandService(CommandManager commandManager) {
    this.commandManager = commandManager;
  }

  @Override
  public Command getCommand(String key) {
    return commandMapper.toBean(commandManager.getCommand(key));
  }

  @Override
  public List<Command> getCommands() {
    return commandMapper.toBean(commandManager.getCommands());
  }

  @Override
  public void create(String key, String name, String description) {
    CommandModel model = new CommandModel();
    model.setKey(key.toLowerCase());
    model.setName(name);
    if (name == null) {
      model.setName(StringUtils.capitalize(model.getKey()));
    }
    model.setDescription(description);
    create(model);
  }

  @Override
  public void create(CommandModel model) {
    commandManager.create(model);
  }

}
