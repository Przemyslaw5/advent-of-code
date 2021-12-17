package com.adventofcode;

import com.adventofcode.common.Day;

import java.util.ArrayList;
import java.util.List;

public class Day3 extends Day {

    public Day3() {
        super(3);
    }

    public int numberOfOnesAtNthBit(List<String> lines, int n) {
        return lines.stream().map(line -> line.charAt(n) - '0').mapToInt(Integer::intValue).sum();
    }

    @Override
    public Object partOne() {
        List<String> lines = getDataAsStringList();

        int[] mostCommonBits = new int[lines.get(0).length()];

        for (int i = 0; i < lines.get(0).length(); i++) {
            mostCommonBits[i] = numberOfOnesAtNthBit(lines, i);
        }

        long gammaRateBin = 0;
        long epsilonRateBin = 0;
        for (int i = 0; i < lines.get(0).length(); i++) {
            int value = mostCommonBits[i];
            gammaRateBin *= 10;
            epsilonRateBin *= 10;
            if (value > lines.size() / 2) gammaRateBin += 1;
            else epsilonRateBin += 1;
        }

        long gammaRateDec = Utils.convertBinaryToDecimal(gammaRateBin);
        long epsilonRateDec = Utils.convertBinaryToDecimal(epsilonRateBin);

        return gammaRateDec * epsilonRateDec;
    }

    public long getRatingForPartTwo(List<String> lines, int numberToFind) {
        int bitNumber = 0;
        while (lines.size() >= 2) {
            int numberOfOnes  = numberOfOnesAtNthBit(lines, bitNumber);
            List<String> newLines = new ArrayList<>();
            for (String line : lines) {
                if (numberOfOnes >= (lines.size() + 1) / 2) {
                    if (line.charAt(bitNumber) - '0' == numberToFind) {
                        newLines.add(line);
                    }
                }
                else {
                    if (line.charAt(bitNumber) - '0' != numberToFind) {
                        newLines.add(line);
                    }
                }
            }

            lines = newLines;
            bitNumber++;
        }
        long binaryValue = Long.parseLong(lines.get(0));
        return Utils.convertBinaryToDecimal(binaryValue);
    }

    @Override
    public Object partTwo() {
        List<String> lines = getDataAsStringList();

        long oxygenGeneratorRating = getRatingForPartTwo(lines, 1);
        long CO2ScrubberRating = getRatingForPartTwo(lines, 0);
        return oxygenGeneratorRating * CO2ScrubberRating;
    }

    public static void main(String[] args) {
        new Day3().solveParts();
    }
}
