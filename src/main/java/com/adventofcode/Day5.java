package com.adventofcode;

import com.adventofcode.common.Day;
import com.adventofcode.common.Point;

import java.util.HashSet;
import java.util.Set;

public class Day5 extends Day {

    public Day5() {
        super(5);
    }

    public void addLineVent(Point startPoint, Point endPoint, Set<Point> linePoints, Set<Point> duplicatedPoints) {
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

    public void addDiagonalVent(Point startPoint, Point endPoint, Set<Point> linePoints, Set<Point> duplicatedPoints) {
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

    @Override
    public Object partOne() {
        Set<Point> linePoints = new HashSet<>();
        Set<Point> duplicatedPoints = new HashSet<>();

        for (String line : getDataAsStringList()) {
            String[] vent = line.split(" -> ");
            Point startPoint = new Point(vent[0]);
            Point endPoint = new Point(vent[1]);

            if (startPoint.x == endPoint.x || startPoint.y == endPoint.y) {
                addLineVent(startPoint, endPoint, linePoints, duplicatedPoints);
            }
        }
        return duplicatedPoints.size();
    }

    @Override
    public Object partTwo() {
        Set<Point> linePoints = new HashSet<>();
        Set<Point> duplicatedPoints = new HashSet<>();

        for (String line : getDataAsStringList()) {
            String[] vent = line.split(" -> ");
            Point startPoint = new Point(vent[0]);
            Point endPoint = new Point(vent[1]);

            if (startPoint.x == endPoint.x || startPoint.y == endPoint.y) {
                addLineVent(startPoint, endPoint, linePoints, duplicatedPoints);
            }
            else if (Math.abs(startPoint.x - endPoint.x) == Math.abs(startPoint.y - endPoint.y)) {
                addDiagonalVent(startPoint, endPoint, linePoints, duplicatedPoints);
            }
        }
        return duplicatedPoints.size();
    }

    public static void main(String[] args) {
        new Day5().solveTasks();
    }
}
