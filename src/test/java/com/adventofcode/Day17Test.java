package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day17Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day17();
        assertEquals("45", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day17();
        assertEquals("2278", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day17();
        assertEquals("112", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day17();
        assertEquals("996", day.solveTaskPart2());
    }

}