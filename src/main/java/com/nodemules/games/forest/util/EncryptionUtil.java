package com.nodemules.games.forest.util;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author brent
 * @since 11/18/17.
 */
@Slf4j
@Component
public final class EncryptionUtil {

  private static PasswordEncoder passwordEncoder;

  private EncryptionUtil() {
    /* empty private constructor */
  }

  @PostConstruct
  private static void setPasswordEncoder() {
    log.info("EncryptionUtil::setPasswordEncoder");
    passwordEncoder = new BCryptPasswordEncoder();
    log.info("passwordEncoder={}", passwordEncoder);
  }

  public static String encrypt(String raw) {
    log.info("passwordEncoder={}", passwordEncoder);
    log.info("encoding raw password: {}", raw);
    return passwordEncoder.encode(raw);
  }

  public static boolean decrypt(String raw, String encrypted) {
    return passwordEncoder.matches(raw, encrypted);
  }
}
