package com.example.android1_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AnagramClassTest {
    @Test(timeout = 10000)
    public void reverseWithoutFilterOnlyAlphabeticIsCorrect() {
        char[] sample = "247".toCharArray();
        AnagramCreator.reverse(sample,0,sample.length - 1, "");
        assertEquals("247", String.copyValueOf(sample));
    }

    @Test(timeout = 10000)
    public void reverseWithoutFilterOnlyFiguresAndNonAlphbeticIsCorrect() {
        char[] sample = "24/7".toCharArray();
        AnagramCreator.reverse(sample,0,sample.length - 1, "");
        assertEquals("24/7", String.copyValueOf(sample));
    }

    @Test(timeout = 10000)
    public void reverseWithoutFilterMixedSympolsIsCorrect() {
        char[] sample = "Foxminded".toCharArray();
        AnagramCreator.reverse(sample,0,sample.length - 1, "");
        assertEquals("dednimxoF", String.copyValueOf(sample));

        sample = "abcd".toCharArray();
        AnagramCreator.reverse(sample,0,sample.length - 1, "");
        assertEquals("dcba", String.copyValueOf(sample));

        sample = "a1bcd".toCharArray();
        AnagramCreator.reverse(sample,0,sample.length - 1, "");
        assertEquals("d1cba", String.copyValueOf(sample));
    }

    @Test(timeout = 10000)
    public void reverseWithFilterOnlyAlphabeticIsCorrect() {
        char[] sample = "247".toCharArray();
        AnagramCreator.reverse(sample,0,sample.length - 1, "xl");
        assertEquals("742", String.copyValueOf(sample));
    }

    @Test(timeout = 10000)
    public void reverseWithFilterOnlyFiguresAndNonAlphbeticIsCorrect() {
        char[] sample = "24/7".toCharArray();
         AnagramCreator.reverse(sample,0,sample.length - 1, "xl");
        assertEquals("7/42", String.copyValueOf(sample));
    }

    @Test(timeout = 10000)
    public void reverseWithFilterMixedSympolsIsCorrect() {
        String filter = "xl";

        char[] sample = "Foxminded".toCharArray();
        AnagramCreator.reverse(sample,0,sample.length - 1, filter);
        assertEquals("dexdnimoF", String.copyValueOf(sample));

        sample = "abcd".toCharArray();
        AnagramCreator.reverse(sample,0,sample.length - 1, filter);
        assertEquals("dcba", String.copyValueOf(sample));

        sample = "a1bcd".toCharArray();
        AnagramCreator.reverse(sample,0,sample.length - 1, filter);
        assertEquals("dcb1a", String.copyValueOf(sample));
    }

    @Test(timeout = 10000)
    public void calculateAnagramWithTextWithoutFilter(){
        assertEquals("dednimxoF looc 24/7",  AnagramCreator.calculateAnagram("Foxminded cool 24/7", ""));
        assertEquals("dcba hgfe", AnagramCreator.calculateAnagram("abcd efgh", ""));
        assertEquals("d1cba hgf!e",  AnagramCreator.calculateAnagram("a1bcd efg!h", ""));
    }

    @Test(timeout = 10000)
    public void calculateAnagramWithTextWithoutFilterWithExtraSpaces(){
        assertEquals(" dednimxoF looc   24/7  ",   AnagramCreator.calculateAnagram(" Foxminded cool   24/7  ", ""));
        assertEquals("   dcba hgfe",  AnagramCreator.calculateAnagram("   abcd efgh", ""));
        assertEquals("d1cba   hgf!e", AnagramCreator.calculateAnagram("a1bcd   efg!h", ""));
    }

    @Test(timeout = 10000)
    public void calculateAnagramWithTextWithFilter(){
        String filter = "xl";
        assertEquals("dexdnimoF oocl 7/42", AnagramCreator.calculateAnagram("Foxminded cool 24/7", filter));
        assertEquals("dcba hgfe",     AnagramCreator.calculateAnagram("abcd efgh", filter));
        assertEquals("dcb1a hgfle", AnagramCreator.calculateAnagram("a1bcd efglh", filter));
    }

    @Test(timeout = 10000)
    public void calculateAnagramTextIsSpacesOrEmpty(){
        String expected = "";
        assertEquals(expected, AnagramCreator.calculateAnagram("", ""));
        assertEquals(expected, AnagramCreator.calculateAnagram(" ", ""));
        assertEquals(expected,  AnagramCreator.calculateAnagram("   ", ""));
    }
}
