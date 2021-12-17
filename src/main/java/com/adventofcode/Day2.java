package com.adventofcode;

import com.adventofcode.common.Day;

public class Day2 extends Day {

    public Day2() {
        super(2);
    }

    @Override
    public Object partOne() {
        int depth = 0;
        int horizontalPosition = 0;
        for (String command : getDataAsStringList()) {
            String direction = command.split(" ")[0];
            int value = Integer.parseInt(command.split(" ")[1]);
            switch (direction) {
                case "up" -> depth -= value;
                case "down" -> depth += value;
                case "forward" -> horizontalPosition += value;
            }
        }
        return horizontalPosition * depth;
    }

    @Override
    public Object partTwo() {
        int depth = 0;
        int horizontalPosition = 0;
        int aim = 0;
        for (String command : getDataAsStringList()) {
            String direction = command.split(" ")[0];
            int value = Integer.parseInt(command.split(" ")[1]);
            switch (direction) {
                case "up" -> aim -= value;
                case "down" -> aim += value;
                case "forward" -> {
                    horizontalPosition += value;
                    depth += aim * value;
                }
            }
        }
        return horizontalPosition * depth;
    }

    public static void main(String[] args) {
        new Day2().solveTasks();
    }
}
