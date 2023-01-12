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
        final char[] text = sourceText.toCharArray();
        int startIdx = -1;
        for (int i = 0; i < sourceText.length(); i++) {
            if (startIdx == -1) {
                if (Character.isSpaceChar(sourceText.charAt(i))) {
                    continue;
                } else {
                    startIdx = i;
                }
            }

            if (Character.isSpaceChar(sourceText.charAt(i))) {
                reverse(text, startIdx, i, filter);
                startIdx = -1;
            } else if (i == sourceText.length() - 1) {
                reverse(text, startIdx, i, filter);
            }
        }
        return new String(text);
    }

    private static void reverse(char[] word, int startIdx, int endIdx, String filter) {
        while (startIdx < endIdx) {
            if (!Character.isAlphabetic(word[startIdx]) || filter.indexOf(word[startIdx]) > -1) {
                startIdx++;
            } else if (!Character.isAlphabetic(word[endIdx]) || filter.indexOf(word[endIdx]) > -1) {
                endIdx--;
            } else {
                char tmp = word[startIdx];
                word[startIdx] = word[endIdx];
                word[endIdx] = tmp;
                startIdx++;
                endIdx--;
            }
        }
    }
}
