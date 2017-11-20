package com.nodemules.games.forest.orm.manager;

import com.nodemules.games.forest.model.CommandModel;
import java.util.List;

/**
 * @author brent
 * @since 11/19/17.
 */
public interface CommandManagement {

  CommandModel getCommand(String name);

  List<CommandModel> getCommands();

  void create(CommandModel model);
}
