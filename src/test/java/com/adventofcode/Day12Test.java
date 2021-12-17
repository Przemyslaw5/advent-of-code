package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day12Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day12();
        assertEquals("226", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day12();
        assertEquals("4912", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day12();
        assertEquals("3509", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day12();
        assertEquals("150004", day.solveTaskPart2());
    }

}