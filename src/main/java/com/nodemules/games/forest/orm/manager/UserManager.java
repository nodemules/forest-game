package com.nodemules.games.forest.orm.manager;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.mapper.UserMapper;
import com.nodemules.games.forest.model.UserModel;
import com.nodemules.games.forest.orm.domain.User;
import com.nodemules.games.forest.orm.repository.UserRepository;
import fr.xebia.extras.selma.Selma;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author brent
 * @since 11/18/17.
 */
@Service
public class UserManager implements UserManagement {

  private UserRepository userRepo;
  private static UserMapper userMapper = Selma.builder(UserMapper.class).build();

  @Autowired
  public UserManager(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public void create(UserModel user) throws AuthenticationException {
    if (userRepo.findByUsername(user.getUsername()) != null) {
      throw new AuthenticationException("Username is unavailable");
    }
    userRepo.save(userMapper.toEntity(user));
  }

  @Override
  public UserModel findByUsername(String username) {
    User user = userRepo.findByUsername(username);
    return userMapper.fromEntity(user);
  }

  @Override
  public UserModel loginUser(UserModel user) {
    User u = userRepo.findOne(user.getId());
    u.setLastLoginTime(new Date());
    return userMapper.fromEntity(userRepo.save(u));
  }


}
