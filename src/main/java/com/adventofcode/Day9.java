package com.adventofcode;

import com.adventofcode.common.Day;
import com.adventofcode.common.Grid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day9 extends Day {

    public Day9() {
        super(9);
    }

    record LowPoint(long value, int rowIndex, int colIndex) { }

    public static List<LowPoint> findLowPoint(Grid heightmap) {
        int rows = heightmap.data.length;
        int cols = heightmap.data[0].length;

        List<LowPoint> lowPoints = new ArrayList<>();
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                long height = heightmap.data[i][j];

                if (height == 9) {
                    continue;
                }

                boolean isLowPoint = true;
                for (int[] adjacentPosition : Grid.ADJACENT_SHIFTS_WITHOUT_DIAGONALS) {
                    int newRow = i + adjacentPosition[0];
                    int newCol = j + adjacentPosition[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && heightmap.data[newRow][newCol] <= height) {
                        isLowPoint = false;
                        break;
                    }
                }
                if (isLowPoint) lowPoints.add(new LowPoint(height, i, j));
            }
        }
        return lowPoints;
    }

    public static int computeBasinSize(Grid heightmap, boolean[][] isVisited, int row, int column) {
        if (isVisited[row][column]) return 0;

        isVisited[row][column] = true;

        int result = 0;
        for (int[] adjacentPosition : Grid.ADJACENT_SHIFTS_WITHOUT_DIAGONALS) {
            int newRow = row + adjacentPosition[0];
            int newCol = column + adjacentPosition[1];
            if (newRow >= 0 && newRow < heightmap.data.length && newCol >= 0 && newCol < heightmap.data[0].length &&
                    heightmap.data[newRow][newCol] < 9 && heightmap.data[newRow][newCol] > heightmap.data[row][column]
            ) {
                result += computeBasinSize(heightmap, isVisited, newRow, newCol);
            }
        }
        return 1 + result;
    }

    @Override
    public Object partOne() {
        Grid heightmap = new Grid(getDataAsString(), "");

        return findLowPoint(heightmap).stream()
                .map(elem -> elem.value + 1)
                .mapToLong(Long::longValue)
                .sum();
    }

    @Override
    public Object partTwo() {
        Grid heightmap = new Grid(getDataAsString(), "");

        List<Integer> basinSizes = new ArrayList<>();
        boolean[][] isVisited = new boolean[heightmap.data.length][heightmap.data[0].length];

        findLowPoint(heightmap)
                .forEach(point -> basinSizes.add(computeBasinSize(heightmap, isVisited, point.rowIndex, point.colIndex)));

        return (long) basinSizes.stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .limit(3)
                .reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        new Day9().solveParts();
    }
}
