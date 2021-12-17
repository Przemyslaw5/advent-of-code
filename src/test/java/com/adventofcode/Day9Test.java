package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day9Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day9();
        assertEquals("15", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day9();
        assertEquals("452", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day9();
        assertEquals("1134", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day9();
        assertEquals("1263735", day.solveTaskPart2());
    }

}