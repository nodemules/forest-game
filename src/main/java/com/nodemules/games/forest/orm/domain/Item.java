package com.nodemules.games.forest.orm.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "item")
@AttributeOverride(name = "id", column = @Column(name = "item_id"))
public class Item extends AbstractEntity {

  private String name;
  private String description;

}
