package com.adventofcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day4 {

    record Board(List<Integer> bingo) {

        public boolean crossNumberAndCheckWin(int number) {
            for (int i = 0; i < bingo.size(); i++) {
                if (bingo.get(i) == number) {
                    bingo.set(i, -1);
                    return isWin();
                }
            }
            return false;
        }

        public boolean isWin() {
            int[] startPositionVertically = {0, 1, 2, 3, 4};
            int[] startPositionHorizontally = {0, 5, 10, 15, 20};

            for (int startIndex = 0; startIndex < 5; startIndex++) {
                int startPosition = startPositionVertically[startIndex];
                int sum = 0;
                for (int position = startPosition; position < bingo.size(); position += 5) {
                    sum += bingo.get(position);
                }
                if (sum == -5) return true;
            }

            for (int startIndex = 0; startIndex < 5; startIndex++) {
                int startPosition = startPositionHorizontally[startIndex];
                int sum = 0;
                for (int position = startPosition; position < startPosition + 5; position++) {
                    sum += bingo.get(position);
                }
                if (sum == -5) return true;
            }
            return false;
        }

        public int calculateUnmarkedNumbers() {
            int sum = 0;
            for (Integer number : bingo) {
                if (number != -1) sum += number;
            }
            return sum;
        }
    }

    public static List<Board> readBoards(List<String> lines) {
        List<Board> boards = new ArrayList<>();

        for (int i = 2; i < lines.size(); i += 6) {
            List<Integer> bingo = new ArrayList<>();
            for (int j = i; j < i + 5; j++) {
                String[] numbers = lines.get(j).trim().split("\\s+");
                for (String number: numbers) {
                    bingo.add(Integer.parseInt(number));
                }
            }
            boards.add(new Board(bingo));
        }
        return boards;
    }

    public static void partOne(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);

        String[] luckyNumbers = lines.get(0).split(",");
        List<Board> boards = readBoards(lines);

        for (String number : luckyNumbers) {
            int luckyNumber = Integer.parseInt(number);
            for (Board board : boards) {
                if (board.crossNumberAndCheckWin(luckyNumber)) {
                    int sumUnmarkedNumbers = board.calculateUnmarkedNumbers();
                    System.out.println(luckyNumber * sumUnmarkedNumbers);
                    return;
                }
            }
        }
    }

    public static void partTwo(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);

        String[] luckyNumbers = lines.get(0).split(",");
        List<Board> boards = readBoards(lines);

        for (String number : luckyNumbers) {
            int luckyNumber = Integer.parseInt(number);
            Iterator<Board> i = boards.iterator();
            while (i.hasNext()) {
                Board board = i.next();
                if (board.crossNumberAndCheckWin(luckyNumber)) {
                    int sumUnmarkedNumbers = board.calculateUnmarkedNumbers();
                    if (boards.size() == 1) {
                        System.out.println(luckyNumber * sumUnmarkedNumbers);
                        return;
                    }
                    i.remove();
                }
            }
        }
    }

    public static void main(String[] args) {
        partOne("day4/taskData.txt");
        partTwo("day4/taskData.txt");
    }
}
