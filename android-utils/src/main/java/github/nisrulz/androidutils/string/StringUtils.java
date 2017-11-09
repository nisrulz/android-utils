/*
 * Copyright (C) 2016 Nishant Srivastava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github.nisrulz.androidutils.string;

/**
 * The type String utils.
 *
 * @author Nishant Srivastava
 */
public class StringUtils {

    /**
     * Remove the last specified character
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

    /**
     * Convert string to title case
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

    private StringUtils() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
