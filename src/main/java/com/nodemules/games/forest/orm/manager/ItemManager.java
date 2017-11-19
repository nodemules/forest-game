package com.nodemules.games.forest.orm.manager;

import com.nodemules.games.forest.mapper.ItemMapper;
import com.nodemules.games.forest.model.ItemModel;
import com.nodemules.games.forest.orm.domain.Item;
import com.nodemules.games.forest.orm.repository.ItemRepository;
import fr.xebia.extras.selma.Selma;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author brent
 * @since 11/18/17.
 */
@Service
public class ItemManager implements ItemManagement {

  private ItemRepository itemRepo;

  private static ItemMapper itemMapper = Selma.builder(ItemMapper.class).build();

  @Autowired
  public ItemManager(ItemRepository itemRepo) {
    this.itemRepo = itemRepo;
  }

  @Override
  public ItemModel getItem(String name) {
    Item item = itemRepo.findByName(name);
    return itemMapper.fromEntity(item);
  }

  @Override
  public void create(ItemModel model) {
    itemRepo.save(itemMapper.toEntity(model));
  }

  @Override
  public List<ItemModel> getItems() {
    return itemMapper.fromEntity(itemRepo.findAll());
  }

}
