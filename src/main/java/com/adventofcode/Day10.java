package com.adventofcode;

import java.util.*;

public class Day10 {

    private static final Map<Character, Character> IN_TO_OUT =
            Map.of('(', ')', '[', ']', '{', '}', '<', '>');
    private static final Map<Character, Integer> SYNTAX_ERROR_SCORE =
            Map.of(')', 3, ']', 57, '}', 1197, '>', 25137);
    private static final Map<Character, Integer> COMPLETE_SCORE =
            Map.of('(', 1, '[', 2, '{', 3, '<', 4);

    public static int calculateSyntaxErrorScore(String line) {
        Stack<Character> brackets = new Stack<>();

        for (Character bracket : line.toCharArray()) {
            if (!brackets.empty()) {
                if (IN_TO_OUT.containsKey(bracket)) brackets.push(bracket);
                else if (IN_TO_OUT.get(brackets.lastElement()) == bracket) brackets.pop();
                else return SYNTAX_ERROR_SCORE.get(bracket);
            }
            else brackets.push(bracket);
        }
        return 0;
    }

    public static void partOne(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);

        long totalSyntaxErrorScore = lines.stream()
                .map(Day10::calculateSyntaxErrorScore)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(totalSyntaxErrorScore);
    }

    public static long calculateScore(String line) {
        Stack<Character> brackets = new Stack<>();

        for (Character bracket : line.toCharArray()) {
            if (!brackets.empty()) {
                if (IN_TO_OUT.containsKey(bracket)) brackets.push(bracket);
                else brackets.pop();
            }
            else brackets.push(bracket);
        }

        Collections.reverse(brackets);
        long totalScore = 0;
        for (Character bracket : brackets) {
            totalScore *= 5;
            totalScore += COMPLETE_SCORE.get(bracket);
        }
        return totalScore;
    }

    public static void partTwo(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);

        List<Long> list = lines.stream()
                .filter(line -> calculateSyntaxErrorScore(line) == 0)
                .map(Day10::calculateScore)
                .sorted()
                .toList();

        long score = list.get(list.size() / 2);

        System.out.println(score);
    }

    public static void main(String[] args) {
        partOne("day10/taskData.txt");
        partTwo("day10/taskData.txt");
    }
}
