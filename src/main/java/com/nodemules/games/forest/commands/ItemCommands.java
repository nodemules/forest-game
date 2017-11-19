package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.model.ItemModel;
import com.nodemules.games.forest.objects.Item;
import com.nodemules.games.forest.service.ItemOperations;
import com.nodemules.games.forest.service.ItemService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author brent
 * @since 11/17/17.
 */
@Slf4j
@ShellComponent
public class ItemCommands {


  private ItemOperations itemService;

  @Autowired
  public ItemCommands(ItemService itemService) {
    this.itemService = itemService;
  }

  @ShellMethod(value = "Makes a new item", key = "item make")
  public String create(
      @ShellOption(help = "The name of the command (defaults to null)") String name,
      @ShellOption(help = "The description of the command (defaults to null)", defaultValue = ShellOption.NULL) String description
  ) {
    ItemModel item = new ItemModel();
    item.setName(name);
    item.setDescription(description);
    itemService.create(item);
    return String.format("Item `%s` created!", name);
  }

  @ShellMethod(value = "Lists items", key = "item list")
  public List<String> listItems() {
    List<Item> items = itemService.getItems();
    log.info("{} items found", items.size());

    return items.stream().map(Item::getName).collect(Collectors.toList());
  }

  @ShellMethod(value = "Prints an item", key = "item print")
  public void print(String name) {
    Item item = new Item();
    item.setName(name);
    item.print();
  }

}
