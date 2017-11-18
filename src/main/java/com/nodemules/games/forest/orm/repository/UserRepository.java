package com.nodemules.games.forest.orm.repository;

import com.nodemules.games.forest.orm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author brent
 * @since 11/18/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
