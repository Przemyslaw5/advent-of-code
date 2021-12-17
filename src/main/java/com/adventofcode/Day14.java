package com.adventofcode;

import com.adventofcode.common.Day;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day14 extends Day {

    public Day14() {
        super(14);
    }

    public <K> void increaseElementByValue(Map<K, Long> map, K key, long value) {
        map.putIfAbsent(key, 0L);
        map.put(key, map.get(key) + value);
    }

    public long solve(int steps) {
        String[] data = getDataAsStringArray("\n\n");
        String polymerTemplate = data[0];

        Map<String, String> pairInsertions = Arrays.stream(data[1].split("\n"))
                .map(rule -> rule.split(" -> "))
                .collect(Collectors.toMap(rule -> rule[0], rule -> rule[1]));

        Map<Character, Long> characterCounter = new HashMap<>();
        polymerTemplate.chars().forEach(elem -> increaseElementByValue(characterCounter, (char) elem, 1));

        Map<String, Long> currentPairOccurrences = new HashMap<>();
        for (int i = 0; i < polymerTemplate.length() - 1; i++) {
            String pair = polymerTemplate.substring(i, i + 2);
            increaseElementByValue(currentPairOccurrences, pair, 1);
        }

        for (int step = 0; step < steps; step++) {
            Map<String, Long> newPairOccurrences = new HashMap<>();
            currentPairOccurrences.forEach((pair, occurrences) -> {
                if (pairInsertions.containsKey(pair)) {
                    String middleLetter = pairInsertions.get(pair);
                    String leftPair = pair.charAt(0) + middleLetter;
                    String rightPair = middleLetter + pair.charAt(1);

                    increaseElementByValue(newPairOccurrences, leftPair, occurrences);
                    increaseElementByValue(newPairOccurrences, rightPair, occurrences);
                    increaseElementByValue(characterCounter, middleLetter.charAt(0), occurrences);
                }
            });
            currentPairOccurrences = newPairOccurrences;
        }

        long maxOccurrences = Collections.max(characterCounter.values());
        long minOccurrences = Collections.min(characterCounter.values());

        return maxOccurrences - minOccurrences;
    }

    @Override
    public Object partOne() {
        return solve(10);
    }

    @Override
    public Object partTwo() {
        return solve(40);
    }

    public static void main(String[] args) {
        new Day14().solveParts();
    }
}