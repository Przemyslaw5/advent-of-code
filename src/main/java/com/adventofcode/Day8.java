package com.adventofcode;

import com.adventofcode.common.Day;

import java.util.*;
import java.util.stream.IntStream;

public class Day8 extends Day {

    public Day8() {
        super(8);
    }

    public static int calculateDigits(String line) {
        String[] inputs = line.split(" \\| ")[0].split(" ");
        String[] outputs = line.split(" \\| ")[1].split(" ");

        Map<String, Integer> results = new HashMap<>();
        List<String> notCalculatedDigits = new ArrayList<>();

        String[] numbers = new String[10];

        for (String digit : inputs) {
            char[] dig = digit.toCharArray();
            Arrays.sort(dig);

            switch (dig.length) {
                case 2 -> numbers[1] = String.valueOf(dig);
                case 3 -> numbers[7] = String.valueOf(dig);
                case 4 -> numbers[4] = String.valueOf(dig);
                case 7 -> numbers[8] = String.valueOf(dig);
                default -> notCalculatedDigits.add(String.valueOf(dig));
            }
        }

        // Find 9 - element that contains all signals from 4
        numbers[9] = notCalculatedDigits.stream()
                .filter(elem -> elem.chars().filter(x -> numbers[4].indexOf(x) != -1).count() == 4)
                .findAny().orElseThrow();
        notCalculatedDigits.remove(numbers[9]);
        results.put(numbers[9], 9);


        // Find 0 - element that contains all signals from 1 and has length 6
        numbers[0] = notCalculatedDigits.stream()
                .filter(elem -> elem.length() == 6)
                .filter(elem -> elem.chars().filter(x -> numbers[1].indexOf(x) != -1).count() == 2)
                .findAny().orElseThrow();
        notCalculatedDigits.remove(numbers[0]);
        results.put(numbers[0], 0);

        // Find 6 - element that has length 6
        numbers[6] = notCalculatedDigits.stream()
                .filter(elem -> elem.length() == 6)
                .findAny().orElseThrow();
        notCalculatedDigits.remove(numbers[6]);
        results.put(numbers[6], 6);

        // Find 3 - element contains all signals from 1
        numbers[3] = notCalculatedDigits.stream()
                .filter(elem -> elem.chars().filter(x -> numbers[1].indexOf(x) != -1).count() == 2)
                .findAny().orElseThrow();
        notCalculatedDigits.remove(numbers[3]);
        results.put(numbers[3], 3);

        // Find 5 - all signals from element exists in 9
        numbers[5] = notCalculatedDigits.stream()
                .filter(elem -> numbers[9].chars().filter(x -> elem.indexOf(x) != -1).count() == 5)
                .findAny().orElseThrow();
        notCalculatedDigits.remove(numbers[5]);
        results.put(numbers[5], 5);

        // Find 2 - last element
        numbers[2] = notCalculatedDigits.get(0);

        IntStream.rangeClosed(0, 9).forEach(elem -> results.put(numbers[elem], elem));

        int result = 0;
        for (String number : outputs) {
            char[] digit = number.toCharArray();
            Arrays.sort(digit);

            result *= 10;
            result += results.get(String.valueOf(digit));
        }
        return result;
    }

    @Override
    public Object partOne() {
        int result = 0;
        for (String line : getDataAsStringList()) {
            String[] digits = line.split(" \\| ")[1].split(" ");
            for (String digit : digits) {
                switch (digit.length()) {
                    case 2, 3, 4, 7 -> result++;
                }
            }
        }
        return result;
    }

    @Override
    public Object partTwo() {
        return getDataAsStringList().stream().map(Day8::calculateDigits).mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        new Day8().solveParts();
    }
}
