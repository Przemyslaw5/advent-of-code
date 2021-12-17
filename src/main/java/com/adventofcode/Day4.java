package com.adventofcode;

import com.adventofcode.common.Day;
import com.adventofcode.common.Grid;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 extends Day {

    public Day4() {
        super(4);
    }

    record Board(Grid numbers) {

        public boolean crossNumberAndCheckWin(int number) {
            for (int i = 0; i < numbers.data.length; i++) {
                for (int j = 0; j < numbers.data[i].length; j++) {
                    if (numbers.data[i][j] == number) {
                        numbers.data[i][j] = -1;
                        return isWin();
                    }
                }
            }
            return false;
        }

        public boolean isWin() {
            for (int index = 0; index < 5; index++) {
                if (numbers.sumElementsVerticallyAtIndex(index) == -5) return true;
                if (numbers.sumElementsHorizontallyAtIndex(index) == -5) return true;
            }
            return false;
        }

        public int sumUnmarkedNumbers() {
            return Arrays.stream(numbers.data).flatMapToInt(Arrays::stream).filter(number -> number != -1).sum();
        }
    }

    @Override
    public Object partOne() {
        String[] data = getDataAsStringArray("\n\n");

        int[] luckyNumbers = Arrays.stream(data[0].split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Board> boards = Arrays.stream(data, 1, data.length)
                .map(boardData -> new Board(new Grid(boardData)))
                .toList();

        for (int luckyNumber : luckyNumbers) {
            for (Board board : boards) {
                if (board.crossNumberAndCheckWin(luckyNumber)) {
                    int sumUnmarkedNumbers = board.sumUnmarkedNumbers();
                    return luckyNumber * sumUnmarkedNumbers;
                }
            }
        }
        return null;
    }

    @Override
    public Object partTwo() {
        String[] data = getDataAsStringArray("\n\n");

        int[] luckyNumbers = Arrays.stream(data[0].split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Board> boards = Arrays.stream(data, 1, data.length)
                .map(boardData -> new Board(new Grid(boardData)))
                .collect(Collectors.toList());

        for (int luckyNumber : luckyNumbers) {
            Iterator<Board> i = boards.iterator();
            while (i.hasNext()) {
                Board board = i.next();
                if (board.crossNumberAndCheckWin(luckyNumber)) {
                    int sumUnmarkedNumbers = board.sumUnmarkedNumbers();
                    if (boards.size() == 1) {
                        return luckyNumber * sumUnmarkedNumbers;
                    }
                    i.remove();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Day4().solveParts();
    }
}
