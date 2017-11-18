package com.nodemules.games.forest.orm.domain;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author brent
 * @since 11/18/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "user")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends AbstractEntity {

  @Column(unique = true)
  private String username;

  @Temporal(TemporalType.TIMESTAMP)
  private Date lastLoginTime;

}
