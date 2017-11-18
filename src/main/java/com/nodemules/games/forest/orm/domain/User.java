package com.nodemules.games.forest.orm.domain;

import com.nodemules.games.forest.util.EncryptionUtil;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
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

  @Column(name = "password")
  private String encryptedPassword;

  @Transient
  private String password;

  @Temporal(TemporalType.TIMESTAMP)
  private Date lastLoginTime;

  @PrePersist
  public void encodePassword() {
    if (this.password != null) {
      this.encryptedPassword = EncryptionUtil.encrypt(this.password);
    }
  }

}
