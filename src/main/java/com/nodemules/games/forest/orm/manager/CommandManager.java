package com.nodemules.games.forest.orm.manager;

import com.nodemules.games.forest.mapper.CommandMapper;
import com.nodemules.games.forest.model.CommandModel;
import com.nodemules.games.forest.orm.repository.CommandRepository;
import fr.xebia.extras.selma.Selma;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author brent
 * @since 11/19/17.
 */
@Slf4j
@Service
public class CommandManager implements CommandManagement {

  private CommandRepository commandRepo;

  private static CommandMapper commandMapper = Selma.builder(CommandMapper.class).build();

  @Autowired
  public CommandManager(CommandRepository commandRepo) {
    this.commandRepo = commandRepo;
  }

  @Override
  public CommandModel getCommand(String value) {
    return commandMapper.fromEntity(commandRepo.findByValue(value));
  }

  @Override
  public List<CommandModel> getCommands() {
    return commandMapper.fromEntity(commandRepo.findAll());
  }

  @Override
  public void create(CommandModel model) {
    log.info("Creating command [{}]: \n{}", model.getKey(), model);
    commandRepo.save(commandMapper.toEntity(model));
  }

}
