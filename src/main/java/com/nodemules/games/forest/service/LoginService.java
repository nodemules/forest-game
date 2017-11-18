package com.nodemules.games.forest.service;

import com.nodemules.games.forest.bean.UserContext;
import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.mapper.UserMapper;
import com.nodemules.games.forest.model.UserModel;
import com.nodemules.games.forest.objects.User;
import com.nodemules.games.forest.orm.manager.UserManagement;
import com.nodemules.games.forest.orm.manager.UserManager;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author brent
 * @since 11/18/17.
 */
@Service
public class LoginService implements LoginOperations {

  private UserManagement userManager;
  private UserContext userContext;
  private static UserMapper userMapper = Selma.builder(UserMapper.class).build();

  @Autowired
  public LoginService(UserManager userManager, UserContext userContext) {
    this.userManager = userManager;
    this.userContext = userContext;
  }

  @Override
  public User login(String username, String password) throws AuthenticationException {
    UserModel user = userManager.loginUser(username, password);
    userContext.setCurrentUser(user);
    return userMapper.toBean(user);
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
