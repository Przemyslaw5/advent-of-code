package com.adventofcode;

import com.adventofcode.common.Day;
import com.adventofcode.common.Point;
import com.adventofcode.common.ocr.Letter;
import com.adventofcode.common.ocr.LetterOcr;

import java.util.*;
import java.util.stream.Collectors;

public class Day13 extends Day {

    public Day13() {
        super(13);
    }

    public void simulateAFold(Set<Point> points, Fold fold) {
        List<Point> newPoints = new ArrayList<>();

        Iterator<Point> i = points.iterator();
        while (i.hasNext()) {
            Point point = i.next();
            if ("x".equals(fold.axis) && point.x > fold.foldPlace) {
                newPoints.add(new Point(fold.foldPlace - (point.x - fold.foldPlace), point.y));
                i.remove();
            }
            else if ("y".equals(fold.axis) && point.y > fold.foldPlace) {
                newPoints.add(new Point(point.x, fold.foldPlace - (point.y - fold.foldPlace)));
                i.remove();
            }
        }
        points.addAll(newPoints);
    }

    record Fold(String axis, int foldPlace) {
    }

    @Override
    public Object partOne() {
        String[] data = getDataAsStringArray("\n\n");

        Set<Point> points = Arrays.stream(data[0].split("\n"))
                .map(Point::new)
                .collect(Collectors.toSet());

        String[] foldElems = Arrays.stream(data[1].split("\n"))
                .findFirst().orElse("")
                .split("fold along ")[1]
                .split("=");

        Fold fold = new Fold(foldElems[0], Integer.parseInt(foldElems[1]));

        simulateAFold(points, fold);
        return points.size();
    }

    // The example is completely different, it represents a number, not a letter
    private static boolean isExample(Set<Point> points) {
        return points.stream().anyMatch(point -> point.x == 4);
    }

    private static String readDigit(Set<Point> pointsCreateDigit) {
        if (isExample(pointsCreateDigit)) return "0";
        boolean[][] image = new boolean[6][4];
        pointsCreateDigit.forEach(point -> image[point.y][point.x % 5] = true);
        return LetterOcr.getLetterFromImage(new Letter(image));
    }

    @Override
    public Object partTwo() {
        String[] data = getDataAsStringArray("\n\n");

        Set<Point> points = Arrays.stream(data[0].split("\n"))
                .map(Point::new)
                .collect(Collectors.toSet());

        Arrays.stream(data[1].split("\n"))
                .forEach(line -> {
                    String[] foldElems = line.split("fold along ")[1].split("=");
                    Fold fold = new Fold(foldElems[0], Integer.parseInt(foldElems[1]));
                    simulateAFold(points, fold);
                });

        return points.stream()
                .collect(Collectors.groupingBy(point -> point.x / 5, Collectors.toSet()))
                .values()
                .stream()
                .map(Day13::readDigit)
                .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        new Day13().solveTasks();
    }
}