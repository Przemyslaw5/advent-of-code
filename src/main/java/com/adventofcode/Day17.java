package com.adventofcode;

import com.adventofcode.common.Day;
import com.adventofcode.common.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day17 extends Day {

    public Day17() {
        super(17);
    }

    public Area readArea() {
        String[] areas = getDataAsStringArray("target area: x=|, y=");
        String[] xPoint = areas[1].split("\\.\\.");
        String[] yPoint = areas[2].split("\\.\\.");
        Point topLeft = new Point(Integer.parseInt(xPoint[0]), Integer.parseInt(yPoint[1]));
        Point bottomRight = new Point(Integer.parseInt(xPoint[1]), Integer.parseInt(yPoint[0]));
        return new Area(topLeft, bottomRight);
    }

    @Override
    public Object partOne() {
        Area area = readArea();
        int startYSpeed = Math.abs(area.bottomRight.y) - 1;
        return startYSpeed * (startYSpeed + 1) / 2;
    }

    record Area(Point topLeft, Point bottomRight) {
        public boolean isPointInside(Point point) {
            return point.x >= topLeft.x && point.x <= bottomRight.x && point.y >= bottomRight.y && point.y <= topLeft.y;
        }
    }

    public boolean isAchieveTarget(Area area, Point speed) {
        Point position = new Point(0, 0);
        while (position.y >= area.bottomRight.y) {
            position.x += speed.x;
            position.y += speed.y;
            if (area.isPointInside(position)) return true;

            if (speed.x > 0) speed.x--;
            else if (speed.x < 0) speed.x++;
            speed.y--;
        }
        return false;
    }

    public Set<Integer> findPossibleXPosition(Area area) {
        Set<Integer> possibleXPositions = new HashSet<>();
        for (int i = 1; i <= area.bottomRight.x; i++) {
            int maxDistance = i * (i + 1) / 2;
            for (int j = 0; j < i; j++) {
                int minDistance = j * (j + 1) / 2;
                if (maxDistance - minDistance >= area.topLeft.x && maxDistance - minDistance <= area.bottomRight.x) {
                    possibleXPositions.add(i);
                    break;
                }
            }
        }
        return possibleXPositions;
    }

    public Set<Integer> findPossibleYPosition(Area area) {
        Set<Integer> possibleYPositions = new HashSet<>();
        for (int i = 0; i <= Math.abs(area.bottomRight.y); i++) {
            int sum = 0;
            for (int j = 0; sum <= Math.abs(area.bottomRight.y); j++) {
                sum += j;
                if (sum >= Math.abs(area.topLeft.y) && sum <= Math.abs(area.bottomRight.y)) {
                    possibleYPositions.add(-i);
                    possibleYPositions.add(i + 1);
                }
            }
        }
        return possibleYPositions;
    }

    @Override
    public Object partTwo() {
        Area area = readArea();

        Set<Integer> possibleXPositions = findPossibleXPosition(area);
        Set<Integer> possibleYPositions = findPossibleYPosition(area);

        List<Point> speeds = new ArrayList<>();
        possibleXPositions.forEach(xPosition -> possibleYPositions.forEach(yPosition -> speeds.add(new Point(xPosition, yPosition))));

        return speeds.stream().filter(speed -> isAchieveTarget(area, speed)).count();
    }

    public static void main(String[] args) {
        new Day17().solveParts();
    }
}
