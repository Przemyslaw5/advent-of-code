package com.adventofcode;

import com.adventofcode.common.Day;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Day6 extends Day {

    public Day6() {
        super(6);
    }

    public static long calculateFishNumber(IntStream ages, int days) {
        long[] lanternFish = new long[9];

        ages.forEach(age -> lanternFish[age]++);

        for (int i = 0; i < days; i++) {
            long births = lanternFish[0];
            System.arraycopy(lanternFish, 1, lanternFish, 0, 8);
            lanternFish[6] += births;
            lanternFish[8] = births;
        }
        return Arrays.stream(lanternFish).sum();
    }

    @Override
    public Object partOne() {
        IntStream ages = getDataAsIntStream(",");
        return calculateFishNumber(ages, 80);
    }

    @Override
    public Object partTwo() {
        IntStream ages = getDataAsIntStream(",");
        return calculateFishNumber(ages, 256);
    }

    public static void main(String[] args) {
        new Day6().solveTasks();
    }
}
