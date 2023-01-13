package com.example.android1_1;

public class AnagramCreator {

    public static String calculateAnagram(String sourceText, String filter) {

        if (sourceText.trim().isEmpty()) {
            return "";
        }

        final char[] text = sourceText.toCharArray();
        final int end = text.length - 1;
        int startIdx = -1;
        for (int i = 0; i <= end; i++) {
            if (startIdx == -1) {
                if (Character.isSpaceChar(text[i])) {
                    continue;
                } else {
                    startIdx = i;
                }
            }

            if (i == end || Character.isSpaceChar(text[i])) {
                int endInd = i == end ? i : i - 1;
                reverse(text, startIdx, endInd, filter);
                startIdx = -1;
            }
        }
        return new String(text);
    }

    private static void reverse(char[] word, int startIdx, int endIdx, String filter) {
        while (startIdx < endIdx) {
            if ((filter.trim().isEmpty() && !Character.isAlphabetic(word[startIdx])) || filter.indexOf(word[startIdx]) > -1) {
                startIdx++;
            } else if ((filter.trim().isEmpty() && !Character.isAlphabetic(word[endIdx])) || filter.indexOf(word[endIdx]) > -1) {
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
