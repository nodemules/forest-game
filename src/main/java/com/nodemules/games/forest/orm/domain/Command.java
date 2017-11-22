package com.nodemules.games.forest.orm.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author brent
 * @since 11/17/17.
 */
@Data
@Entity
@Table(name = "command")
@AttributeOverride(name = "id", column = @Column(name = "command_id"))
public class Command extends AbstractEntity implements Serializable {

  private static final long serialVersionUID = -751326203893962510L;

  @Column(unique = true)
  private String value;

  private String name;
  private String description;

  @OneToMany
  @JoinColumn(name = "alias_id")
  private Set<Alias> aliases;

}
