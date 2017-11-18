package com.nodemules.games.forest.service;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.model.UserModel;
import com.nodemules.games.forest.orm.manager.UserManagement;
import com.nodemules.games.forest.orm.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
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
    user.setPassword(password);
    user.setEmail(email);
    register(user);
  }

  @Override
  public void register(UserModel user) throws AuthenticationException {
    if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
      log.error("Unable to register user: [{}] because a password was not provided.", user.getUsername());
      throw new AuthenticationException("A password is required to create a User");
    }
    log.info("Registering user: {}", user.getUsername());
    userManager.create(user);
  }

}
