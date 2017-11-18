package com.nodemules.games.forest.commands;

import com.nodemules.games.forest.exception.InvalidInputException;
import com.nodemules.games.forest.objects.Item;
import com.nodemules.games.forest.orm.repository.ItemRepository;
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


  private ItemRepository itemRepo;

  @Autowired
  public ItemCommands(ItemRepository itemRepo) {
    this.itemRepo = itemRepo;
  }

  @ShellMethod(value = "Makes a new item", key = "item make")
  public String makeItem(
      @ShellOption(help = "The name of the command (defaults to null)") String name,
      @ShellOption(help = "The description of the command (defaults to null)", defaultValue = "") String description
  ) {
    if (name == null) {
      throw new InvalidInputException("A name is required to make an item");
    }
    com.nodemules.games.forest.orm.domain.Item c = new com.nodemules.games.forest.orm.domain.Item();
    c.setName(name);
    c.setDescription(description);
    itemRepo.save(c);
    return String.format("Item `%s` created!", name);
  }

  @ShellMethod(value = "Lists items", key = "item list")
  public List<String> listItems() {
    List<com.nodemules.games.forest.orm.domain.Item> commands = itemRepo.findAll();

    log.info("{} items found", commands.size());

    return commands.stream().map(com.nodemules.games.forest.orm.domain.Item::getName).collect(Collectors.toList());
  }

  @ShellMethod(value = "Prints an item", key = "item print")
  public void print(String name) {
    Item item = new Item();
    item.setName(name);
    item.print();
  }

}
