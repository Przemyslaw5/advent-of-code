package com.adventofcode;

import java.util.*;

public class Day5 {

    record Point(int x, int y) { }

    public static void partOne(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);

        Set<Point> linePoints = new HashSet<>();
        Set<Point> duplicatedPoints = new HashSet<>();

        for (String line : lines) {
            String[] vent = line.split(" -> |,");
            Point startPoint = new Point(Integer.parseInt(vent[0]), Integer.parseInt(vent[1]));
            Point endPoint = new Point(Integer.parseInt(vent[2]), Integer.parseInt(vent[3]));
            if (startPoint.x == endPoint.x) {
                int x = startPoint.x;
                int yMin = Math.min(startPoint.y, endPoint.y);
                int yMax = Math.max(startPoint.y, endPoint.y);

                for (int y = yMin; y <= yMax; y++) {
                    Point point = new Point(x, y);
                    if (linePoints.contains(point)) duplicatedPoints.add(point);
                    else linePoints.add(point);
                }
            }
            else if (startPoint.y == endPoint.y) {
                int y = startPoint.y;
                int xMin = Math.min(startPoint.x, endPoint.x);
                int xMax = Math.max(startPoint.x, endPoint.x);

                for (int x = xMin; x <= xMax; x++) {
                    Point point = new Point(x, y);
                    if (linePoints.contains(point)) duplicatedPoints.add(point);
                    else linePoints.add(point);
                }
            }
        }
        System.out.println(duplicatedPoints.size());
    }

    public static void partTwo(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);

        Set<Point> linePoints = new HashSet<>();
        Set<Point> duplicatedPoints = new HashSet<>();

        for (String line : lines) {
            String[] vent = line.split(" -> |,");
            Point startPoint = new Point(Integer.parseInt(vent[0]), Integer.parseInt(vent[1]));
            Point endPoint = new Point(Integer.parseInt(vent[2]), Integer.parseInt(vent[3]));
            if (startPoint.x == endPoint.x) {
                int x = startPoint.x;
                int yMin = Math.min(startPoint.y, endPoint.y);
                int yMax = Math.max(startPoint.y, endPoint.y);

                for (int y = yMin; y <= yMax; y++) {
                    Point point = new Point(x, y);
                    if (linePoints.contains(point)) duplicatedPoints.add(point);
                    else linePoints.add(point);
                }
            }
            else if (startPoint.y == endPoint.y) {
                int y = startPoint.y;
                int xMin = Math.min(startPoint.x, endPoint.x);
                int xMax = Math.max(startPoint.x, endPoint.x);

                for (int x = xMin; x <= xMax; x++) {
                    Point point = new Point(x, y);
                    if (linePoints.contains(point)) duplicatedPoints.add(point);
                    else linePoints.add(point);
                }
            }
            else if (Math.abs(startPoint.x - endPoint.x) == Math.abs(startPoint.y - endPoint.y)) {

                int y = startPoint.y;
                int x = startPoint.x;

                int xStep = (endPoint.x - startPoint.x) / Math.abs(endPoint.x - startPoint.x);
                int yStep = (endPoint.y - startPoint.y) / Math.abs(endPoint.y - startPoint.y);

                while (x != endPoint.x + xStep) {
                    Point point = new Point(x, y);
                    if (linePoints.contains(point)) duplicatedPoints.add(point);
                    else linePoints.add(point);

                    x += xStep;
                    y += yStep;
                }
            }
        }
        System.out.println(duplicatedPoints.size());
    }

    public static void main(String[] args) {
        partOne("day5/taskData.txt");
        partTwo("day5/taskData.txt");
    }
}
