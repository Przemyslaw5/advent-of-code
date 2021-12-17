package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day5();
        assertEquals("5", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day5();
        assertEquals("6007", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day5();
        assertEquals("12", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day5();
        assertEquals("19349", day.solveTaskPart2());
    }

}