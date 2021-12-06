package com.adventofcode;

import java.util.Arrays;

public class Day6 {

    public static long calculateFishNumber(String inputLine, int days) {
        long[] lanternFish = new long[9];
        for (String number : inputLine.split(",")) {
            lanternFish[Integer.parseInt(number)]++;
        }

        for (int i = 0; i < days; i++) {
            long temp = lanternFish[0];
            System.arraycopy(lanternFish, 1, lanternFish, 0, 8);
            lanternFish[6] += temp;
            lanternFish[8] = temp;
        }
        return Arrays.stream(lanternFish).sum();
    }

    public static void partOne(String path) {
        String inputLine = Utils.getLinesFromFileInResources(path).get(0);

        System.out.println(calculateFishNumber(inputLine, 80));
    }

    public static void partTwo(String path) {
        String inputLine = Utils.getLinesFromFileInResources(path).get(0);

        System.out.println(calculateFishNumber(inputLine, 256));
    }

    public static void main(String[] args) {
        partOne("day6/taskData.txt");
        partTwo("day6/taskData.txt");
    }
}
