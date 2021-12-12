package com.adventofcode;

import java.util.*;

public class Day12 {

    private static Map<String, List<String>> readInputAndConvertToGraph(String path) {
        List<String> lines = Utils.getLinesFromFileInResources(path);

        Map<String, List<String>> caveGraph = new HashMap<>();
        for (String line : lines) {
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

    private static int computePathsNumber(String caveName, Map<String, List<String>> caveGraph, String path, boolean canSmallCaveVisitTwice) {
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

    public static void partOne(String path) {
        Map<String, List<String>> caveGraph = readInputAndConvertToGraph(path);

        int paths = computePathsNumber("start", caveGraph, "-", false);
        System.out.println(paths);
    }

    public static void partTwo(String path) {
        Map<String, List<String>> caveGraph = readInputAndConvertToGraph(path);

        int paths = computePathsNumber("start", caveGraph, "-", true);
        System.out.println(paths);
    }

    public static void main(String[] args) {
        partOne("day12/taskData.txt");
        partTwo("day12/taskData.txt");
    }
}
