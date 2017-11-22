package com.nodemules.games.forest.orm.repository;

import com.nodemules.games.forest.orm.domain.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author brent
 * @since 11/17/17.
 */
@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {

  Command findByValue(String value);

}
