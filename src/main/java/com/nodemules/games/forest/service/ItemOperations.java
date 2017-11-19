package com.nodemules.games.forest.service;

import com.nodemules.games.forest.model.ItemModel;
import com.nodemules.games.forest.objects.Item;
import java.util.List;

/**
 * @author brent
 * @since 11/18/17.
 */
public interface ItemOperations {

  Item getItem(String name);

  void create(ItemModel item);

  List<Item> getItems();
}
