package com.adventofcode;

import com.adventofcode.common.Day;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Day10 extends Day {

    public Day10() {
        super(10);
    }

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

    @Override
    public Object partOne() {
        return getDataAsStringStream()
                .map(Day10::calculateSyntaxErrorScore)
                .mapToInt(Integer::intValue)
                .sum();
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

        return brackets.stream()
                .map(COMPLETE_SCORE::get)
                .mapToLong(Integer::longValue)
                .reduce(0, (acc, score) -> (5 * acc + score));
    }

    @Override
    public Object partTwo() {
        List<Long> list = getDataAsStringStream()
                .filter(line -> calculateSyntaxErrorScore(line) == 0)
                .map(Day10::calculateScore)
                .sorted()
                .toList();

        return list.get(list.size() / 2);
    }

    public static void main(String[] args) {
        new Day10().solveTasks();
    }
}
