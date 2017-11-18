package com.nodemules.games.forest.mapper;

import com.nodemules.games.forest.model.UserModel;
import com.nodemules.games.forest.orm.domain.User;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

/**
 * @author brent
 * @since 11/18/17.
 */
@Mapper(withIgnoreMissing = IgnoreMissing.ALL)
public interface UserMapper {

  @Maps(withIgnoreFields = {"dateCreated", "dateModified"})
  User toEntity(UserModel user);

  com.nodemules.games.forest.objects.User toBean(UserModel user);

  UserModel fromBean(com.nodemules.games.forest.objects.User user);

  UserModel fromEntity(User user);

}
