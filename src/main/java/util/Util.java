package util;

public class Util {
    /**
     * Converts each word in a string to title case under the assumption
     * that words are always separated by a space.
     * @param str the string
     * @return the string into title case.
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        String[] strSplit = str.split(" ");

        for (int i = 0; i < strSplit.length; i++) {
            String word = strSplit[i];

            String strTitleCase = word.toUpperCase().charAt(0) +
                    word.toLowerCase().substring(1, word.length());

            strSplit[i] = strTitleCase;
        }

        return String.join(" ", strSplit);
    }
}
