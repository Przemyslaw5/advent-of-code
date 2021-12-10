package com.adventofcode;

import java.util.*;

public class Day9 {

    record LowPoint(int value, int rowIndex, int colIndex) { }

    public static int[][] readInputAndConvertToHeightmap(String path){
        List<String> lines = Utils.getLinesFromFileInResources(path);
        int rows = lines.size();
        int cols = lines.get(0).length();

        int[][] heightmap = new int[rows][];
        for (int i = 0; i < rows; i++){
            heightmap[i] = new int[cols];
            for (int j = 0; j < cols; j++){
                heightmap[i][j] = lines.get(i).charAt(j) - '0';
            }
        }
        return heightmap;
    }

    public static List<LowPoint> findLowPoint(int[][] heightmap) {
        int rows = heightmap.length;
        int cols = heightmap[0].length;
        int[][] adjacentPositions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        List<LowPoint> lowPoints = new ArrayList<>();

        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int height = heightmap[i][j];

                if (height == '9') continue;

                boolean isLowPoint = true;
                for (int[] adjacentPosition : adjacentPositions) {
                    int newRow = i + adjacentPosition[0];
                    int newCol = j + adjacentPosition[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && heightmap[newRow][newCol] <= height) {
                        isLowPoint = false;
                        break;
                    }
                }
                if (isLowPoint) lowPoints.add(new LowPoint(height, i, j));
            }
        }
        return lowPoints;
    }

    public static void partOne(String path) {
        int[][] heightmap = readInputAndConvertToHeightmap(path);

        List<LowPoint> lowPoints = findLowPoint(heightmap);

        int riskLevel = lowPoints.stream()
                .map(elem -> elem.value + 1)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(riskLevel);
    }

    public static int computeBasinSize(int[][] heightmap, boolean[][] isVisited, int row, int column) {
        if (isVisited[row][column]) return 0;

        isVisited[row][column] = true;
        int[][] adjacentPositions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int result = 0;
        for (int[] adjacentPosition : adjacentPositions) {
            int newRow = row + adjacentPosition[0];
            int newCol = column + adjacentPosition[1];
            if (newRow >= 0 && newRow < heightmap.length && newCol >= 0 && newCol < heightmap[0].length &&
                    heightmap[newRow][newCol] < 9 && heightmap[newRow][newCol] > heightmap[row][column]
            ) {
                result += computeBasinSize(heightmap, isVisited, newRow, newCol);
            }
        }
        return 1 + result;
    }

    public static void partTwo(String path) {
        int[][] heightmap = readInputAndConvertToHeightmap(path);

        List<LowPoint> lowPoints = findLowPoint(heightmap);

        List<Integer> basinSizes = new ArrayList<>();
        boolean[][] isVisited = new boolean[heightmap.length][heightmap[0].length];

        lowPoints.forEach(point -> basinSizes.add(computeBasinSize(heightmap, isVisited, point.rowIndex, point.colIndex)));

        long result = basinSizes.stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .limit(3)
                .reduce(1, (a, b) -> a * b);

        System.out.println(result);
    }

    public static void main(String[] args) {
        partOne("day9/taskData.txt");
        partTwo("day9/taskData.txt");
    }
}
