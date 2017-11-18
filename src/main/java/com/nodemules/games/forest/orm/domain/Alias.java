package com.nodemules.games.forest.orm.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Alias implements Serializable {

  private static final long serialVersionUID = -8879830458708438400L;

  @Id
  @Column(name="alias_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String value;

  @ManyToOne
  @JoinColumn(name = "command_id")
  private Command command;

}
