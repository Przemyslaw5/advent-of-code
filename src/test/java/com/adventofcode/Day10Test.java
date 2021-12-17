package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day10Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day10();
        assertEquals("26397", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day10();
        assertEquals("462693", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day10();
        assertEquals("288957", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day10();
        assertEquals("3094671161", day.solveTaskPart2());
    }

}