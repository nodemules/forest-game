package com.nodemules.games.forest.orm.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 * @author brent
 * @since 11/18/17.
 */
@Data
@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue
  protected Long id;

  @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Timestamp dateCreated;

  @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  private Timestamp dateModified;

}
