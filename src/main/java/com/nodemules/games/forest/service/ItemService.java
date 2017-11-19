package com.nodemules.games.forest.service;

import com.nodemules.games.forest.mapper.ItemMapper;
import com.nodemules.games.forest.model.ItemModel;
import com.nodemules.games.forest.objects.Item;
import com.nodemules.games.forest.orm.manager.ItemManagement;
import com.nodemules.games.forest.orm.manager.ItemManager;
import fr.xebia.extras.selma.Selma;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author brent
 * @since 11/18/17.
 */
@Service
public class ItemService implements ItemOperations {

  private ItemManagement itemManager;

  private static ItemMapper itemMapper = Selma.builder(ItemMapper.class).build();

  public ItemService(ItemManager itemManager) {
    this.itemManager = itemManager;
  }

  @Override
  public Item getItem(String name) {
    return itemMapper.toBean(itemManager.getItem(name));
  }

  @Override
  public void create(ItemModel item) {
    itemManager.create(item);
  }

  @Override
  public List<Item> getItems() {
    return itemMapper.toBean(itemManager.getItems());
  }

}
