package com.adventofcode;

public class Utils {

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

}