package com.adventofcode;

import java.util.List;

public class Day1 {

    public static void partOne(String path) {
        List<Integer> depths = Utils.getNumbersFromFileInResources(path);

        int result = 0;
        for(int i = 1; i < depths.size(); i++){
            if(depths.get(i - 1) < depths.get(i)){
                result++;
            }
        }
        System.out.println(result);
    }

    public static void partTwo(String path) {
        List<Integer> depths = Utils.getNumbersFromFileInResources(path);

        int result = 0;
        int previousValue = Integer.MAX_VALUE;

        for(int i = 0; i < depths.size() - 2; i++){
            int sum = depths.get(i) + depths.get(i + 1) + depths.get(i + 2);
            if (sum > previousValue) {
                result++;
            }
            previousValue = sum;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        partOne("day1/taskData.txt");
        partTwo("day1/taskData.txt");
    }
}
