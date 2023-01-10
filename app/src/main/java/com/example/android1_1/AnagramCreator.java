package com.example.android1_1;


public class AnagramCreator {

    public static String calculateAnagram(String sourceText, String filter) {

        //The original text cannot be changed, but its trimmed version is checked.
        int textLength = sourceText.trim().length();
        if (textLength == 0) {
            return "";
        } else if (textLength == 1) {
            return sourceText;
        }

        StringBuilder result = new StringBuilder();
        int startInd = -1;

        for (int i = 0; i < sourceText.length(); i++) {
            if (startInd == -1) {
                if (sourceText.charAt(i) != ' ') {
                    startInd = i;
                } else {
                    result.append(sourceText.charAt(i));
                }
                continue;
            }

            if (sourceText.charAt(i) == ' ') {
                result.append(reverse(sourceText.substring(startInd, i), filter));
                result.append(sourceText.charAt(i));
                startInd = -1;
            } else if (i == sourceText.length() - 1) {
                result.append(reverse(sourceText.substring(startInd, i + 1), filter));
            }
        }
        return result.toString();
    }

    private static char[] reverse(String text, String filter) {

        int textLength = text.length();
        char[] result = new char[textLength];
        boolean[] pass = new boolean[textLength];

        for (int i = 0; i < text.length(); i++) {
            char sym = text.charAt(i);
            if (!Character.isAlphabetic(sym) || filter.indexOf(sym) > -1) {
                result[i] = sym;
                pass[i] = true;
            }
        }

        int endInd = textLength - 1;
        for (int i = 0; i < text.length() && endInd >= 0; i++) {
            char sym = text.charAt(endInd);

            if (!Character.isAlphabetic(sym) || filter.contains(String.valueOf(sym))) {
                endInd--;
                i--;
                continue;
            }

            if (!pass[i]) {
                result[i] = sym;
                endInd--;
            }
        }

        return result;
    }
}
