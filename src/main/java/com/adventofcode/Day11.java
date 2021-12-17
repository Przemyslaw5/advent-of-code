package com.adventofcode;

import com.adventofcode.common.Day;
import com.adventofcode.common.Grid;

import java.util.stream.IntStream;

public class Day11 extends Day {

    public Day11() {
        super(11);
    }

    private void increaseEnergy(Grid energyLevels, int row, int col) {
        if (++energyLevels.data[row][col] == 10) {
            for (int[] adjacentPosition : Grid.ADJACENT_SHIFTS_WITH_DIAGONALS) {
                int rowIndex = row + adjacentPosition[0];
                int colIndex = col + adjacentPosition[1];
                if (energyLevels.isInside(rowIndex, colIndex) && energyLevels.data[rowIndex][colIndex] <= 9) {
                    increaseEnergy(energyLevels, rowIndex, colIndex);
                }
            }
        }
    }

    private int simulateStepAndGetFlashes(Grid energyLevels) {
        for (int row = 0; row < energyLevels.getRowsNumber(); row++) {
            for (int col = 0; col < energyLevels.getColsNumber(); col++) {
                increaseEnergy(energyLevels, row, col);
            }
        }

        int flashes = 0;
        for (int row = 0; row < energyLevels.getRowsNumber(); row++) {
            for (int col = 0; col < energyLevels.getColsNumber(); col++) {
                if (energyLevels.data[row][col] > 9) {
                    energyLevels.data[row][col] = 0;
                    flashes++;
                }
            }
        }
        return flashes;
    }

    @Override
    public Object partOne() {
        Grid energyLevels = new Grid(getDataAsString(), "");

        return IntStream.range(0, 100).map(step -> simulateStepAndGetFlashes(energyLevels)).sum();
    }

    @Override
    public Object partTwo() {
        Grid energyLevels = new Grid(getDataAsString(), "");

        int step = 1;
        while (simulateStepAndGetFlashes(energyLevels) != energyLevels.getRowsNumber() * energyLevels.getColsNumber()) {
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        new Day11().solveParts();
    }
}
