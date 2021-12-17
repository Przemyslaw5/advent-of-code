package com.adventofcode;

import com.adventofcode.common.Day;
import com.adventofcode.common.Grid;

import java.util.PriorityQueue;
import java.util.Queue;

public class Day15 extends Day {

    public Day15() {
        super(15);
    }

    static class CaveElement implements Comparable<CaveElement> {

        public int row;
        public int col;
        public int cost;

        public CaveElement(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(CaveElement o) {
            return (this.cost > o.cost ? 1 : -1);
        }
    }

    public void calculateCosts(Grid riskLevels, Grid costs) {
        Queue<CaveElement> caveElements = new PriorityQueue<>();
        caveElements.add(new CaveElement(0, 0, 0));

        while (!caveElements.isEmpty()) {
            CaveElement caveElement = caveElements.poll();
            if (caveElement.row == costs.getRowsNumber() - 1 && caveElement.col == costs.getColsNumber() - 1) {
                return;
            }
            for (int[] adjacentPosition : Grid.ADJACENT_SHIFTS_WITHOUT_DIAGONALS) {
                int rowIndex = caveElement.row + adjacentPosition[0];
                int colIndex = caveElement.col + adjacentPosition[1];
                if (costs.isInside(rowIndex, colIndex)) {
                    int riskLevel = riskLevels.data[rowIndex % riskLevels.getRowsNumber()][colIndex % riskLevels.getColsNumber()] + rowIndex / riskLevels.getRowsNumber() + colIndex / riskLevels.getColsNumber();
                    if (riskLevel >= 10) riskLevel -= 9;

                    if (costs.data[rowIndex][colIndex] > riskLevel + caveElement.cost) {
                        costs.data[rowIndex][colIndex] = riskLevel + caveElement.cost;
                        caveElements.add(new CaveElement(rowIndex, colIndex, riskLevel + caveElement.cost));
                    }
                }
            }
        }
    }

    @Override
    public Object partOne() {
        Grid riskLevels = new Grid(getDataAsString(), "");
        Grid costs = Grid.createGrid(riskLevels.getRowsNumber(), riskLevels.getColsNumber(), Integer.MAX_VALUE);

        calculateCosts(riskLevels, costs);
        return costs.getBottomRightValue();
    }

    @Override
    public Object partTwo() {
        Grid riskLevels = new Grid(getDataAsString(), "");
        Grid costs = Grid.createGrid(riskLevels.getRowsNumber() * 5, riskLevels.getColsNumber() * 5, Integer.MAX_VALUE);

        calculateCosts(riskLevels, costs);
        return costs.getBottomRightValue();
    }

    public static void main(String[] args) {
        new Day15().solveParts();
    }
}