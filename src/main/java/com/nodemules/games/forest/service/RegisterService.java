package com.nodemules.games.forest.service;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.model.UserModel;
import com.nodemules.games.forest.orm.manager.UserManagement;
import com.nodemules.games.forest.orm.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author brent
 * @since 11/18/17.
 */
@Service
public class RegisterService implements RegisterOperations {

  private UserManagement userManager;

  @Autowired
  public RegisterService(UserManager userManager) {
    this.userManager = userManager;
  }

  @Override
  public void register(String username, String password, String email) throws AuthenticationException {
    UserModel user = new UserModel();
    user.setUsername(username);
    register(user);
  }

  @Override
  public void register(UserModel user) throws AuthenticationException {
    userManager.create(user);
  }

}
