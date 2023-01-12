package com.example.android1_1;


import androidx.core.content.res.TypedArrayUtils;

import java.util.Arrays;

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
                if (!Character.isSpaceChar(sourceText.charAt(i))) {
                    startInd = i;
                } else {
                    result.append(sourceText.charAt(i));
                }
                continue;
            }

            if (Character.isSpaceChar(sourceText.charAt(i))) {
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

        char[] result = text.toCharArray();
        int textLength = text.length();
        boolean[] pass = new boolean[textLength];

        int backward, toward;
        for (backward = textLength - 1, toward = 0; toward < textLength; backward--, toward++) {

            char replSym = text.charAt(toward);
            if (pass[toward] || !Character.isAlphabetic(replSym) || filter.indexOf(replSym) > -1) {
                backward++; //reset iteration
                continue;
            }

            char sym = text.charAt(backward);
            if (!Character.isAlphabetic(sym) || filter.indexOf(sym) > -1) {
                pass[backward] = true;
                toward--; //reset iteration
                continue;
            }

            result[toward] = sym;

        }

        return result;
    }
}
