package com.nodemules.games.forest.orm.domain;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author brent
 * @since 11/17/17.
 */
@Data
@Entity
@Table(name = "command_alias")
@AttributeOverride(name = "id", column = @Column(name = "alias_id"))
public class Alias extends AbstractEntity implements Serializable {

  private static final long serialVersionUID = -8879830458708438400L;

  private String value;

  @ManyToOne
  @JoinColumn(name = "command_id")
  private Command command;

}
