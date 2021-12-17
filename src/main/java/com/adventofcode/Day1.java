package com.adventofcode;

import com.adventofcode.common.Day;

public class Day1 extends Day {

    public Day1() {
        super(1);
    }

    @Override
    public Object partOne() {
        int[] depths = getDataAsIntArray();

        int result = 0;
        for(int i = 1; i < depths.length; i++) {
            if(depths[i - 1] < depths[i]) {
                result++;
            }
        }
        return result;
    }

    @Override
    public Object partTwo() {
        int[] depths = getDataAsIntArray();

        int result = 0;
        int previousValue = Integer.MAX_VALUE;

        for(int i = 0; i < depths.length - 2; i++){
            int sum = depths[i] + depths[i + 1] + depths[i + 2];
            if (sum > previousValue) {
                result++;
            }
            previousValue = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        new Day1().solveParts();
    }
}
