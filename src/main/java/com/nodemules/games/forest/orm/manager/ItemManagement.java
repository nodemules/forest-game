package com.nodemules.games.forest.orm.manager;

import com.nodemules.games.forest.model.ItemModel;
import java.util.List;

/**
 * @author brent
 * @since 11/18/17.
 */
public interface ItemManagement {

  ItemModel getItem(String name);

  void create(ItemModel model);

  List<ItemModel> getItems();
}
