package com.nodemules.games.forest.test.integration.commands;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author brent
 * @since 11/19/17.
 */
@Slf4j
public class CryptoCommandsTest extends AbstractAuthenticatedTestSuite {

  private static final int EXPECTED_ENCRYPTED_STRING_LENGTH = 60;

  private static final String COMMAND_CRYPTO_ENCRYPT = "crypto encrypt";

  private static final String TEST_UNENCRYPTED_STRING = "unencrypted";

  @Test
  public void testEncrypt() {
    String result = execute(formatCommand(COMMAND_CRYPTO_ENCRYPT, TEST_UNENCRYPTED_STRING));
    Assert.assertEquals(EXPECTED_ENCRYPTED_STRING_LENGTH, result.length());
  }

}
