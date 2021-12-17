package com.adventofcode;

import com.adventofcode.common.Day;

import java.util.ArrayList;
import java.util.List;

public class Day7 extends Day {

    public Day7() {
        super(7);
    }

    @Override
    public Object partOne() {
        List<Integer> numbers = getDataAsIntStream(",").sorted().boxed().toList();

        // Best position is median of data
        int median = numbers.get(numbers.size() / 2);

        return numbers.stream().map(number -> Math.abs(number - median)).mapToInt(Integer::intValue).sum();
    }

    @Override
    public Object partTwo() {
        List<Integer> numbers = getDataAsIntStream(",").sorted().boxed().toList();

        // Best position is average of data
        int average = (int) numbers.stream().mapToDouble(x -> x).average().orElse(0.0);
        List<Integer> values = List.of(average, average + 1);

        long bestFuel = Long.MAX_VALUE;
        for (int value : values) {
            long fuel = 0;
            for (Integer number : numbers) {
                long n = Math.abs(number - value);
                fuel += n * (n + 1) / 2;
            }
            if (fuel < bestFuel) bestFuel = fuel;
        }

        return bestFuel;
    }

    public static void main(String[] args) {
        new Day7().solveTasks();
    }
}
