package util;
public class Util {
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

