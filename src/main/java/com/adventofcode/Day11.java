package com.adventofcode;

import java.util.List;

public class Day11 {

    private static final int[][] ADJACENT_POSITIONS = new int[][] {{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};

    public static int[][] readInputAndConvertToEnergyLevelsArray(String path){
        List<String> lines = Utils.getLinesFromFileInResources(path);
        int rows = lines.size();
        int cols = lines.get(0).length();

        int[][] energyLevels = new int[rows][];
        for (int i = 0; i < rows; i++){
            energyLevels[i] = new int[cols];
            for (int j = 0; j < cols; j++){
                energyLevels[i][j] = lines.get(i).charAt(j) - '0';
            }
        }
        return energyLevels;
    }

    public static void increaseEnergy(int[][] energyLevels, int row, int col) {
        if (++energyLevels[row][col] == 10) {
            for (int[] adjacentPosition : ADJACENT_POSITIONS) {
                int newRow = row + adjacentPosition[0];
                int newCol = col + adjacentPosition[1];
                if (newRow >= 0 && newRow < energyLevels.length && newCol >= 0 && newCol < energyLevels[row].length && energyLevels[newRow][newCol] <= 9) {
                    increaseEnergy(energyLevels, newRow, newCol);
                }
            }
        }
    }

    private static int simulateStepAndGetFlashes(int[][] energyLevels) {
        int flashes = 0;
        for (int row = 0; row < energyLevels.length; row++) {
            for (int col = 0; col < energyLevels[row].length; col++) {
                increaseEnergy(energyLevels, row, col);
            }
        }
        for (int row = 0; row < energyLevels.length; row++) {
            for (int col = 0; col < energyLevels[row].length; col++) {
                if (energyLevels[row][col] > 9) {
                    energyLevels[row][col] = 0;
                    flashes++;
                }
            }
        }
        return flashes;
    }

    public static void partOne(String path) {
        int[][] energyLevels = readInputAndConvertToEnergyLevelsArray(path);

        int step = 1;
        int flashes = 0;
        while (step++ <= 100) {
            flashes += simulateStepAndGetFlashes(energyLevels);
        }

        System.out.println(flashes);
    }

    public static void partTwo(String path) {
        int[][] energyLevels = readInputAndConvertToEnergyLevelsArray(path);

        int rowsNumber = energyLevels.length;
        int colsNumber = energyLevels[0].length;
        int step = 1;

        while (simulateStepAndGetFlashes(energyLevels) != rowsNumber * colsNumber) {
            step++;
        }

        System.out.println(step);
    }

    public static void main(String[] args) {
        partOne("day11/taskData.txt");
        partTwo("day11/taskData.txt");
    }
}
