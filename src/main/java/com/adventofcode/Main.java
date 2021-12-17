package com.adventofcode;

import com.adventofcode.common.Day;

public class Main {
    public static void main(String[] args) throws Exception {
        for (int dayNumber = 1; dayNumber <= 13; dayNumber++) {
            System.out.println("Day " + dayNumber + ": ");
            Day day = (Day) Class.forName("com.adventofcode.Day" + dayNumber).getDeclaredConstructor().newInstance();
            day.solveParts();
            System.out.println();
        }
    }
}
