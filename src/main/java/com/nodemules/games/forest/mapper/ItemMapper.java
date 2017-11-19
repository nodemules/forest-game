package com.nodemules.games.forest.mapper;

import com.nodemules.games.forest.model.ItemModel;
import com.nodemules.games.forest.orm.domain.Item;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import java.util.List;

/**
 * @author brent
 * @since 11/18/17.
 */
@Mapper(withIgnoreMissing = IgnoreMissing.ALL)
public interface ItemMapper {

  @Maps(withIgnoreFields = {"dateCreated", "dateModified"})
  Item toEntity(ItemModel model);

  com.nodemules.games.forest.objects.Item toBean(ItemModel model);

  List<com.nodemules.games.forest.objects.Item> toBean(List<ItemModel> models);

  List<ItemModel> fromEntity(List<Item> items);

  ItemModel fromEntity(Item item);

  ItemModel fromBean(com.nodemules.games.forest.objects.Item item);

}
