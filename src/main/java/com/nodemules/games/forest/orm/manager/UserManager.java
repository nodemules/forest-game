package com.nodemules.games.forest.orm.manager;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.mapper.UserMapper;
import com.nodemules.games.forest.model.UserModel;
import com.nodemules.games.forest.orm.domain.User;
import com.nodemules.games.forest.orm.repository.UserRepository;
import com.nodemules.games.forest.util.EncryptionUtil;
import fr.xebia.extras.selma.Selma;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
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
    User u = userRepo.findByUsername(user.getUsername());

    Integer i = userRepo.countByUsername(user.getUsername());

    log.info("{} users found with user: \n{}", i, user);
    if (u != null) {
      throw new AuthenticationException("Username is unavailable");
    }
    User newUser = userMapper.toEntity(user);
    newUser.setPassword(user.getPassword());
    userRepo.save(newUser);
  }

  @Override
  public UserModel findByUsername(String username) {
    User user = userRepo.findByUsername(username);
    return userMapper.fromEntity(user);
  }

  @Override
  public UserModel loginUser(String username, String password) throws AuthenticationException {
    UserModel user = new UserModel();
    user.setUsername(username);
    user.setPassword(password);
    return loginUser(user);
  }

  @Override
  public UserModel loginUser(UserModel user) throws AuthenticationException {
    User u = userRepo.findByUsername(user.getUsername());
    if (u == null) {
      throw new AuthenticationException("User not found!");
    }
    boolean validPassword = EncryptionUtil.decrypt(user.getPassword(), u.getEncryptedPassword());
    if (user.getPassword() == null || !validPassword) {
      throw new AuthenticationException("Invalid password!");
    }
    u.setLastLoginTime(new Date());
    return userMapper.fromEntity(userRepo.save(u));
  }


}
