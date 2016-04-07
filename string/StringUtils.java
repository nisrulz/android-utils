package github.nisrulz.scripts.string;

/**
 * The type String utils.
 *
 * @author Nishant Srivastava
 */
public class StringUtils {
    /**
     * To title case string.
     *
     * @param input the input
     * @return the string
     */
    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

    /**
     * Remove last char string.
     *
     * @param stringText the string text
     * @param endingChar the ending char
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
