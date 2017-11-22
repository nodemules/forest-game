package com.nodemules.games.forest.bean;

import com.nodemules.games.forest.exception.AuthenticationException;
import com.nodemules.games.forest.model.UserModel;
import com.nodemules.games.forest.util.DateTimeUtil;
import java.util.Date;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
@Getter
public class UserContext {

  private UserModel currentUser;
  private Date lastLoginTime;
  private Date lastLogoutTime;

  public void login(UserModel userModel) throws AuthenticationException {
    if (userModel == null) {
      throw new AuthenticationException("Cannot login without a valid user");
    }
    currentUser = userModel;
    lastLoginTime = new Date();
    lastLogoutTime = null;
  }

  public void logout() throws AuthenticationException {
    if (currentUser == null) {
      throw new AuthenticationException("Cannot logout a user who is not logged in");
    }
    lastLogoutTime = new Date();
    log.debug("Logging out [{}], logged in for: {} milliseconds", currentUser.getUsername(),
        DateTimeUtil.elapsedTime(lastLoginTime, lastLogoutTime));
    currentUser = null;
  }

  public boolean isUserLoggedIn() {
    return currentUser != null;
  }
}
