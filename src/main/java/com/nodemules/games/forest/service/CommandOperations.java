package com.nodemules.games.forest.service;

import com.nodemules.games.forest.model.CommandModel;
import com.nodemules.games.forest.objects.Command;
import java.util.List;

/**
 * @author brent
 * @since 11/19/17.
 */
public interface CommandOperations {

  Command getCommand(String key);

  List<Command> getCommands();

  void create(String key, String name, String description);

  void create(CommandModel model);

}
