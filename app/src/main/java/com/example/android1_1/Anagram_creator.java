package com.example.android1_1;

import java.util.ArrayList;

public class Anagram_creator {

    public static String getAnagram(String sourceText, String filter) {
        char[] text = sourceText.toCharArray();
        StringBuilder result = new StringBuilder();
        int startInd = -1;

        for (int i = 0; i < text.length; i++) {
            if (startInd == -1) {
                if (text[i] != ' ') {
                    startInd = i;
                } else {
                    result.append(text[i]);
                }
                continue;
            }

            if (text[i] == ' ') {
                result.append(reverse(text, filter, startInd, i - 1));
                result.append(text[i]);
                startInd = -1;
            } else if (i == text.length - 1) {
                result.append(reverse(text, filter, startInd, i));
            }
        }
        return result.toString();
    }

    private static char[] reverse(char[] text, String filter, int start, int end) {

        char[] result = new char[end - start + 1];
        ArrayList<Integer> pass = new ArrayList<>();

        int ind = start;
        while (ind <= end) {
            char sym = text[ind];
            if (!Character.isAlphabetic(sym) || filter.contains(String.valueOf(sym))) {
                result[ind - start] = sym;
                pass.add(ind - start);
            }
            ind++;
        }


        for (int i = 0; i < result.length && start <= end; i++) {
            char sym = text[end];

            if (!Character.isAlphabetic(sym) || filter.contains(String.valueOf(sym))) {
                end--;
                i--;
                continue;
            }

            if (!pass.contains(i)) {
                result[i] = sym;
                end--;
            }
        }

        return result;
    }
}
