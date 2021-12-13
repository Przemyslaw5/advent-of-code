package com.adventofcode;

import com.adventofcode.common.LetterOcr;
import com.adventofcode.common.Point;

import java.util.*;

public class Day13 {

    public static Set<Point> readInputAndConvertToSetOfPoints(List<String> lines){
        Set<Point> points = new HashSet<>();
        lines.stream()
                .filter(line -> !(line.startsWith("fold") || line.equals("")))
                .forEach(line -> points.add(new Point(line)));
        return points;
    }

    public static void simulateAFold(Set<Point> points, Fold fold) {
        List<Point> newPoints = new ArrayList<>();

        Iterator<Point> i = points.iterator();
        while (i.hasNext()) {
            Point point = i.next();
            if ("x".equals(fold.axis) && point.getX() > fold.foldPlace) {
                newPoints.add(new Point(fold.foldPlace - (point.getX() - fold.foldPlace), point.getY()));
                i.remove();
            }
            else if ("y".equals(fold.axis) && point.getY() > fold.foldPlace) {
                newPoints.add(new Point(point.getX(), fold.foldPlace - (point.getY() - fold.foldPlace)));
                i.remove();
            }
        }
        points.addAll(newPoints);
    }

    record Fold(String axis, int foldPlace) {
    }

    public static void partOne(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);
        Set<Point> points = readInputAndConvertToSetOfPoints(lines);

        String[] foldElems = lines.stream()
                .filter(elem -> elem.startsWith("fold"))
                .findFirst().orElse("")
                .split("fold along ")[1]
                .split("=");
        Fold fold = new Fold(foldElems[0], Integer.parseInt(foldElems[1]));
        simulateAFold(points, fold);

        System.out.println(points.size());
    }

    private static String readDigit(Set<Point> pointsCreateDigit) {
        boolean[][] image = new boolean[6][4];
        pointsCreateDigit.forEach(point -> image[point.getY()][point.getX()] = true);
        return LetterOcr.getLetterFromImage(image);
    }

    public static String readCodeFromPoints(Set<Point> points) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            Set<Point> pointsCreateDigit = new HashSet<>();
            for (Point point : points) {
                if (point.getX() >= 5 * i && point.getX() < 5 * (i + 1)) {
                    point.moveVerticallyByN(-5 * i);
                    pointsCreateDigit.add(point);
                }
            }
            code.append(readDigit(pointsCreateDigit));
        }
        return code.toString();
    }

    public static void partTwo(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);
        Set<Point> points = readInputAndConvertToSetOfPoints(lines);

        lines.stream()
                .filter(line -> line.startsWith("fold"))
                .forEach(line -> {
                    String[] foldElems = line.split("fold along ")[1].split("=");
                    Fold fold = new Fold(foldElems[0], Integer.parseInt(foldElems[1]));
                    simulateAFold(points, fold);
                });

        String result = readCodeFromPoints(points);
        System.out.println(result);
    }

    public static void main(String[] args) {
        partOne("day13/taskData.txt");
        partTwo("day13/taskData.txt");
    }
}