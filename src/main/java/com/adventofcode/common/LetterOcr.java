package com.adventofcode.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LetterOcr {
    private static final Map<boolean[][], String> LETTERS = new HashMap<>();

    static {
        LETTERS.put(new boolean[][] {
                {false, true,  true,  false},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  true,  true,  true},
                {true,  false, false, true},
                {true,  false, false, true}}, "A");
        LETTERS.put(new boolean[][] {
                {true,  true,  true,  false},
                {true,  false, false, true},
                {true,  true,  true,  false},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  true,  true,  false}}, "B");
        LETTERS.put(new boolean[][] {
                {false, true,  true,  false},
                {true,  false, false, true},
                {true,  false, false, false},
                {true,  false, false, false},
                {true,  false, false, true},
                {false, true,  true,  false}}, "C");
        LETTERS.put(new boolean[][] {
                {true, true,  true,  false},
                {true, false, false, true},
                {true, false, false, true},
                {true, false, false, true},
                {true, false, false, true},
                {true, true,  true,  false}}, "D");
        LETTERS.put(new boolean[][] {
                {true,  true,  true,  true},
                {true,  false, false, false},
                {true,  true,  true,  false},
                {true,  false, false, false},
                {true,  false, false, false},
                {true,  true,  true,  true}}, "E");
        LETTERS.put(new boolean[][] {
                {true,  true,  true,  true},
                {true,  false, false, false},
                {true,  true,  true,  false},
                {true,  false, false, false},
                {true,  false, false, false},
                {true,  false, false, false}}, "F");
        LETTERS.put(new boolean[][] {
                {false, true,  true,  false},
                {true,  false, false, true},
                {true,  false, false, false},
                {true,  false, true,  true},
                {true,  false, false, true},
                {false, true,  true,  true}}, "G");
        LETTERS.put(new boolean[][] {
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  true,  true,  true},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true}}, "H");
        LETTERS.put(new boolean[][] {
                {false, true,  true,  true},
                {false, false, true,  false},
                {false, false, true,  false},
                {false, false, true,  false},
                {false, false, true,  false},
                {false, true,  true,  true}}, "I");
        LETTERS.put(new boolean[][] {
                {false, false, true,  true},
                {false, false, false, true},
                {false, false, false, true},
                {false, false, false, true},
                {true,  false, false, true},
                {false, true,  true,  false}}, "J");
        LETTERS.put(new boolean[][] {
                {true,  false, false, true},
                {true,  false, true,  false},
                {true,  true,  false, false},
                {true,  false, true,  false},
                {true,  false, true,  false},
                {true,  false, false, true}}, "K");
        LETTERS.put(new boolean[][] {
                {true,  false, false, false},
                {true,  false, false, false},
                {true,  false, false, false},
                {true,  false, false, false},
                {true,  false, false, false},
                {true,  true,  true,  true}}, "L");
        LETTERS.put(new boolean[][] {
                {true,  false, false, true},
                {true,  true,  true,  true},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true}}, "M");
        LETTERS.put(new boolean[][] {
                {true,  false, false, true},
                {true,  true,  false, true},
                {true,  true,  false, true},
                {true,  false, true,  true},
                {true,  false, true,  true},
                {true,  false, false, true}}, "N");
        LETTERS.put(new boolean[][] {
                {false, true,  true,  false},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true},
                {false, true,  true,  false}}, "O");
        LETTERS.put(new boolean[][] {
                {true,  true,  true,  false},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  true,  true,  false},
                {true,  false, false, false},
                {true,  false, false, false}}, "P");
        LETTERS.put(new boolean[][] {
                {true,  true,  true,  false},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  true,  true,  false},
                {true,  false, true,  false},
                {true,  false, false, true}}, "R");
        LETTERS.put(new boolean[][] {
                {false, true,  true,  true},
                {true,  false, false, false},
                {true,  false, false, false},
                {false, true,  true,  false},
                {false, false, false, true},
                {true,  true,  true,  false}}, "S");
        LETTERS.put(new boolean[][] {
                {true,  true, true, true},
                {false, true, true, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, true, true, false}}, "T");
        LETTERS.put(new boolean[][] {
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true},
                {false, true,  true,  false}}, "U");
        LETTERS.put(new boolean[][] {
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  false, false, true},
                {true,  true,  true,  true},
                {true,  false, false, true}}, "W");
        LETTERS.put(new boolean[][] {
                {true,  false, false, true},
                {true,  false, false, true},
                {false, true,  true,  false},
                {false, true,  true,  false},
                {true,  false, false, true},
                {true,  false, false, true}}, "X");
        LETTERS.put(new boolean[][] {
                {true, true, true, true},
                {false, false, false, true},
                {false, false, true, false},
                {false, true, false, false},
                {true, false, false, false},
                {true, true, true, true}}, "Z");
    }

    public static String getLetterFromImage(boolean[][] image) {
        String letter = "";
        for (Map.Entry<boolean[][],String> entry : LETTERS.entrySet())
            if (Arrays.deepEquals(entry.getKey(), image)) letter = entry.getValue();
        return letter;
    }
}