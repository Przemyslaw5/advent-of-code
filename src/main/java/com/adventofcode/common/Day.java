package com.adventofcode.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public abstract class Day {
    public static final String DEFAULT_DELIMITER = "\n";
    private final int dayNumber;
    private boolean isExample = false;

    public Day(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public abstract Object partOne();

    public abstract Object partTwo();

    public void solveParts() {
        isExample = false;
        System.out.println("Part one: " + partOne());
        System.out.println("Part two: " + partTwo());
    }

    public void solveExamples() {
        isExample = true;
        System.out.println("Part one: " + partOne());
        System.out.println("Part two: " + partTwo());
    }

    public String getPathToFile() {
        return "day" + dayNumber + "/" + (isExample ? "example" : "taskData") + ".txt";
    }

    public String getDataAsString() {
        String path = getPathToFile();
        try {
            return Files.readString(Path.of(Objects.requireNonNull(Day.class.getClassLoader().getResource(path)).getFile()));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public String[] getDataAsStringArray() {
        return getDataAsStringArray(DEFAULT_DELIMITER);
    }

    public String[] getDataAsStringArray(String delimiter) {
        return getDataAsString().split(delimiter);
    }

    public Stream<String> getDataAsStringStream() {
        return getDataAsStringStream(DEFAULT_DELIMITER);
    }

    public Stream<String> getDataAsStringStream(String delimiter) {
        return Arrays.stream(getDataAsStringArray(delimiter));
    }

    public List<String> getDataAsStringList() {
        return getDataAsStringList(DEFAULT_DELIMITER);
    }

    public List<String> getDataAsStringList(String delimiter) {
        return getDataAsStringStream(delimiter).toList();
    }

    public int[] getDataAsIntArray() {
        return getDataAsIntArray(DEFAULT_DELIMITER);
    }

    public int[] getDataAsIntArray(String delimiter) {
        return getDataAsIntStream(delimiter).toArray();
    }

    public IntStream getDataAsIntStream() {
        return getDataAsIntStream(DEFAULT_DELIMITER);
    }

    public IntStream getDataAsIntStream(String delimiter) {
        return getDataAsStringStream(delimiter).mapToInt(Integer::parseInt);
    }

    public List<Integer> getDataAsIntegerList() {
        return getDataAsIntegerList(DEFAULT_DELIMITER);
    }

    public List<Integer> getDataAsIntegerList(String delimiter) {
        return getDataAsIntStream(delimiter).boxed().toList();
    }

    public double[] getDataAsDoubleArray() {
        return getDataAsDoubleArray(DEFAULT_DELIMITER);
    }

    public double[] getDataAsDoubleArray(String delimiter) {
        return getDataAsDoubleStream(delimiter).toArray();
    }

    public DoubleStream getDataAsDoubleStream() {
        return getDataAsDoubleStream(DEFAULT_DELIMITER);
    }

    public DoubleStream getDataAsDoubleStream(String delimiter) {
        return getDataAsStringStream(delimiter).mapToDouble(Double::parseDouble);
    }

    public List<Double> getDataAsDoubleList() {
        return getDataAsDoubleList(DEFAULT_DELIMITER);
    }

    public List<Double> getDataAsDoubleList(String delimiter) {
        return getDataAsDoubleStream(delimiter).boxed().toList();
    }

    public long[] getDataAsLongArray() {
        return getDataAsLongArray(DEFAULT_DELIMITER);
    }

    public long[] getDataAsLongArray(String delimiter) {
        return getDataAsLongStream(delimiter).toArray();
    }

    public LongStream getDataAsLongStream() {
        return getDataAsLongStream(DEFAULT_DELIMITER);
    }

    public LongStream getDataAsLongStream(String delimiter) {
        return getDataAsStringStream(delimiter).mapToLong(Long::parseLong);
    }

    public List<Long> getDataAsLongList() {
        return getDataAsLongList(DEFAULT_DELIMITER);
    }

    public List<Long> getDataAsLongList(String delimiter) {
        return getDataAsLongStream(delimiter).boxed().toList();
    }

    //TODO - Dodanie czytanie całego grida do charArray albo coś

}
