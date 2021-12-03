package com.adventofcode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> getNumbersFromFileInResources(String path) {
        List<String> lines = getLinesFromFileInResources(path);

        List<Integer> numbers = new ArrayList<>();
        for(String number : lines){
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }

    public static List<Long> getLongsFromFileInResources(String path) {
        List<String> lines = getLinesFromFileInResources(path);

        List<Long> numbers = new ArrayList<>();
        for(String number : lines){
            numbers.add(Long.valueOf(number));
        }
        return numbers;
    }

    public static List<String> getLinesFromFileInResources(String path) {
        try{
            return Files.readAllLines(Path.of(Utils.class.getClassLoader().getResource(path).toURI()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}