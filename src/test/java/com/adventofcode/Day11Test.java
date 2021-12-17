package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day11Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day11();
        assertEquals("1656", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day11();
        assertEquals("1640", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day11();
        assertEquals("195", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day11();
        assertEquals("312", day.solveTaskPart2());
    }

}