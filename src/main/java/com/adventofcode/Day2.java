package com.adventofcode;

import java.util.List;

public class Day2 {

    public static void partOne(String path) {
        List<String> commands = Utils.getLinesFromFileInResources(path);

        int depth = 0;
        int horizontalPosition = 0;
        for (String command : commands) {
            String direction = command.split(" ")[0];
            int value = Integer.parseInt(command.split(" ")[1]);
            switch (direction) {
                case "up" -> depth -= value;
                case "down" -> depth += value;
                case "forward" -> horizontalPosition += value;
            }
        }
        System.out.println(horizontalPosition * depth);
    }

    public static void partTwo(String path) {
        List<String> commands = Utils.getLinesFromFileInResources(path);

        int depth = 0;
        int horizontalPosition = 0;
        int aim = 0;
        for (String command : commands) {
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
        System.out.println(horizontalPosition * depth);
    }

    public static void main(String[] args) {
        partOne("day2/taskData.txt");
        partTwo("day2/taskData.txt");
    }
}
