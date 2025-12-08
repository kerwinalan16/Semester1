package util;
public class Util {
    /**
     * Converts each word in a string to title case.
     * Assumes words are separated by a single space.
     * Example: "yi wang, computer science and math" -> "Yi Wang, Computer Science And Math"
     * @param str the input string
     * @return the string converted to title case
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] words = str.split(" ");
        String titleCase = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                String firstChar = word.substring(0, 1).toUpperCase();
                String rest = "";
                if (word.length() > 1) {
                    rest = word.substring(1).toLowerCase();
                }
                titleCase += firstChar + rest;
            }
            if (i < words.length - 1) {
                titleCase += " ";
            }
        }

        return titleCase;
    }
}

