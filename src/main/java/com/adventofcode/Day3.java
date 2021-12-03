package com.adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static long convertBinaryToDecimal(long binaryNumber) {
        long decimalNumber = 0;
        int multiply = 1;

        while (binaryNumber != 0) {
            decimalNumber += (binaryNumber % 10) * multiply;
            binaryNumber /= 10;
            multiply *= 2;
        }
        return decimalNumber;
    }

    public static void partOne(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);

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

        long gammaRateDec = convertBinaryToDecimal(gammaRateBin);
        long epsilonRateDec = convertBinaryToDecimal(epsilonRateBin);
        System.out.println(gammaRateDec * epsilonRateDec);
    }

    public static int numberOfOnesAtNthBit(List<String> lines, int n) {
        int result = 0;

        for (String line : lines) {
            result+= line.charAt(n) - '0';
        }
        return result;
    }

    public static long getRatingForPartTwo(List<String> lines, int numberToFind) {
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
        return convertBinaryToDecimal(binaryValue);
    }

    public static void partTwo(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);

        long oxygenGeneratorRating = getRatingForPartTwo(lines, 1);
        long CO2ScrubberRating = getRatingForPartTwo(lines, 0);
        System.out.println(oxygenGeneratorRating * CO2ScrubberRating);
    }

    public static void main(String[] args) {
        partOne("day3/taskData.txt");
        partTwo("day3/taskData.txt");
    }
}
