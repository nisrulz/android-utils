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
}
