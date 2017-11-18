package com.nodemules.games.forest.orm.repository;

import com.nodemules.games.forest.orm.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
