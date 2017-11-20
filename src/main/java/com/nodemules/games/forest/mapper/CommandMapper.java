package com.nodemules.games.forest.mapper;

import com.nodemules.games.forest.model.CommandModel;
import com.nodemules.games.forest.orm.domain.Command;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import java.util.List;

/**
 * @author brent
 * @since 11/19/17.
 */
@Mapper(
    withCustomFields = {@Field(value = {"CommandModel.key", "Command.value"})},
    withIgnoreMissing = IgnoreMissing.ALL)
public interface CommandMapper {

  Command toEntity(CommandModel model);

  com.nodemules.games.forest.objects.Command toBean(CommandModel model);

  List<com.nodemules.games.forest.objects.Command> toBean(List<CommandModel> models);

  CommandModel fromEntity(Command command);

  List<CommandModel> fromEntity(List<Command> commands);

  CommandModel fromBean(com.nodemules.games.forest.objects.Command command);

}
