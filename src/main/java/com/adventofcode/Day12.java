package com.adventofcode;

import com.adventofcode.common.Day;

import java.util.*;

public class Day12 extends Day {

    public Day12() {
        super(12);
    }

    private Map<String, List<String>> readInputAndConvertToGraph() {
        Map<String, List<String>> caveGraph = new HashMap<>();
        for (String line : getDataAsStringList()) {
            String[] cavePath = line.split("-");
            String caveA = cavePath[0];
            String caveB = cavePath[1];
            if (!caveGraph.containsKey(caveA)) {
                caveGraph.put(caveA, new LinkedList<>());
            }
            if (!caveGraph.containsKey(caveB)) {
                caveGraph.put(caveB, new LinkedList<>());
            }
            caveGraph.get(caveA).add(caveB);
            caveGraph.get(caveB).add(caveA);
        }
        return caveGraph;
    }

    private int computePathsNumber(String caveName, Map<String, List<String>> caveGraph, String path, boolean canSmallCaveVisitTwice) {
        if ("end".equals(caveName))  return 1;

        boolean isSmallAndVisitedCave = path.contains("-" + caveName + "-") && caveName.toLowerCase(Locale.ROOT).equals(caveName);
        boolean isStartIsVisited = "start".equals(caveName) && path.contains("start");

        if ((isSmallAndVisitedCave && !canSmallCaveVisitTwice) || isStartIsVisited) return 0;
        if (isSmallAndVisitedCave) canSmallCaveVisitTwice = false;
        path += caveName + "-";

        int result = 0;
        for (String reachableCave : caveGraph.get(caveName)) {
            result += computePathsNumber(reachableCave, caveGraph, path, canSmallCaveVisitTwice);
        }
        return result;
    }

    @Override
    public Object partOne() {
        Map<String, List<String>> caveGraph = readInputAndConvertToGraph();

        return computePathsNumber("start", caveGraph, "-", false);
    }

    @Override
    public Object partTwo() {
        Map<String, List<String>> caveGraph = readInputAndConvertToGraph();

        return computePathsNumber("start", caveGraph, "-", true);
    }

    public static void main(String[] args) {
        new Day12().solveParts();
    }
}
