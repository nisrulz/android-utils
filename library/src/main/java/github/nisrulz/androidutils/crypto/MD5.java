package github.nisrulz.androidutils.crypto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The type Md 5.
 */
public class MD5 {

  private MD5() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Get MD5 value for a string
   *
   * @param input
   *     the input
   * @return the string
   */
  public static String md5(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] messageDigest = md.digest(input.getBytes());
      BigInteger number = new BigInteger(1, messageDigest);
      String md5 = number.toString(16);

      while (md5.length() < 32) {
        md5 = "0" + md5;
      }

      return md5;
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
  }
}
