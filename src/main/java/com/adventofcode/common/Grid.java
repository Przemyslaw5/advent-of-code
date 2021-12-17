package com.adventofcode.common;

import java.util.Arrays;

public class Grid {

    private static final String DEFAULT_LINE_DELIMITER = "\n";
    private static final String DEFAULT_ELEMENT_DELIMITER = " ";
    public static final int[][] ADJACENT_SHIFTS_WITHOUT_DIAGONALS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static final int[][] ADJACENT_SHIFTS_WITH_DIAGONALS = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};

    public int[][] data;
    private final int rowsNumber;
    private final int colsNumber;

    public Grid(String data) {
        this(data, DEFAULT_LINE_DELIMITER, DEFAULT_ELEMENT_DELIMITER);
    }

    public Grid(String data, String elementDelimiter) {
        this(data, DEFAULT_LINE_DELIMITER, elementDelimiter);
    }

    public Grid(String data, String lineDelimiter, String elementDelimiter) {
        this.data = readData(data, lineDelimiter, elementDelimiter);
        this.rowsNumber = this.data.length;
        this.colsNumber = this.data[0].length;
    }

    private Grid(int [][] data) {
        this.data = data;
        this.rowsNumber = this.data.length;
        this.colsNumber = this.data[0].length;
    }

    private int[][] readData(String data, String lineDelimiter, String elementDelimiter) {
        String[] lines = data.split(lineDelimiter);
        int[][] numbers = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            numbers[i] = Arrays.stream(lines[i].split(elementDelimiter))
                    .map(String::trim)
                    .filter(e -> !e.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return numbers;
    }

    public static Grid createGrid(int rowsNumber, int colsNumber, int initValue) {
        int[][] numbers = new int[rowsNumber][colsNumber];
        Arrays.stream(numbers).forEach(row -> Arrays.fill(row, initValue));
        return new Grid(numbers);
    }

    public int sumElementsHorizontallyAtIndex(int index) {
        return Arrays.stream(data[index]).sum();
    }

    public int sumElementsVerticallyAtIndex(int index) {
        return Arrays.stream(data)
                .map(row -> row[index])
                .mapToInt(Integer::intValue)
                .sum();
    }

    public boolean isInside(int rowIndex, int colIndex) {
        return rowIndex >= 0 && rowIndex < rowsNumber && colIndex >= 0 && colIndex < colsNumber;
    }

    public int getTopLeftValue() {
        return data[0][0];
    }

    public int getTopRightValue() {
        return data[0][colsNumber - 1];
    }

    public int getBottomRightValue() {
        return data[rowsNumber - 1][colsNumber - 1];
    }

    public int getBottomLeftValue() {
        return data[rowsNumber - 1][0];
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public int getColsNumber() {
        return colsNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int number : row) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
        }
        return sb.append("\n").toString();
    }
}
