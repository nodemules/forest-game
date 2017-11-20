package com.nodemules.games.forest.service;

import com.nodemules.games.forest.bean.UserContext;
import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.mapper.UserMapper;
import com.nodemules.games.forest.model.UserModel;
import com.nodemules.games.forest.objects.User;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author brent
 * @since 11/18/17.
 */
@Service
public class AuthenticationService implements AuthenticationOperations {

  private UserContext userContext;
  private static UserMapper userMapper = Selma.builder(UserMapper.class).build();

  @Autowired
  public AuthenticationService(UserContext userContext) {
    this.userContext = userContext;
  }

  @Override
  public User whoami() throws AuthenticationException {
    UserModel currentUser = userContext.getCurrentUser();
    if (currentUser == null) {
      throw new AuthenticationException("User is not logged in!");
    }
    return userMapper.toBean(currentUser);
  }

  @Override
  public boolean isUserLoggedIn() {
    return userContext.isUserLoggedIn();
  }

}
