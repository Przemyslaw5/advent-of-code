package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day6();
        assertEquals("5934", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day6();
        assertEquals("365862", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day6();
        assertEquals("26984457539", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day6();
        assertEquals("1653250886439", day.solveTaskPart2());
    }

}