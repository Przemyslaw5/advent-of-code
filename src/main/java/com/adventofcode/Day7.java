package com.adventofcode;

import java.util.Arrays;
import java.util.List;

public class Day7 {

    public static void partOne(String path) {
        String inputLine = Utils.getLinesFromFileInResources(path).get(0);

        List<Integer> numbers = Arrays.stream(inputLine.split(",")).map(Integer::parseInt).sorted().toList();

        // Best position is median of data
        int median = numbers.get(numbers.size() / 2);

        long fuel = 0;
        for (Integer number : numbers) {
            fuel += Math.abs(number - median);
        }

        System.out.println(fuel);
    }

    public static void partTwo(String path) {
        String inputLine = Utils.getLinesFromFileInResources(path).get(0);

        List<Integer> numbers = Arrays.stream(inputLine.split(",")).map(Integer::parseInt).sorted().toList();

        // Best position is average of data
        int average = (int) numbers.stream().mapToDouble(x -> x).average().orElse(0.0);

        long fuel = 0;
        for (Integer number : numbers) {
            long n = Math.abs(number - average);
            fuel += n * (n + 1) / 2;
        }

        System.out.println(fuel);
    }

    public static void main(String[] args) {
        partOne("day7/taskData.txt");
        partTwo("day7/taskData.txt");
    }
}
