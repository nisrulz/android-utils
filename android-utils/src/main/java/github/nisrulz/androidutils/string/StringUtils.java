package github.nisrulz.androidutils.string;

/**
 * The type String utils.
 *
 * @author Nishant Srivastava
 */
public class StringUtils {

  private StringUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Convert string to title case
   *
   * @param input
   *     the input
   * @return the string
   */
  public static String toTitleCase(String input) {
    StringBuilder titleCase = new StringBuilder();
    boolean nextTitleCase = true;

    for (char c : input.toCharArray()) {
      if (Character.isSpaceChar(c)) {
        nextTitleCase = true;
      }
      else if (nextTitleCase) {
        c = Character.toTitleCase(c);
        nextTitleCase = false;
      }

      titleCase.append(c);
    }

    return titleCase.toString();
  }

  /**
   * Remove the last specified character
   *
   * @param stringText
   *     the string text
   * @param endingChar
   *     the ending char
   * @return the string
   */
  public static String removeLastChar(String stringText, String endingChar) {
    if (!stringText.equals("") && stringText != null) {
      if (stringText.endsWith(endingChar)) {
        stringText = stringText.substring(0, stringText.length() - 1);
      }
    }
    return stringText;
  }
}
