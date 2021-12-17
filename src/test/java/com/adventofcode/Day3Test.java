package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day3();
        assertEquals("198", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day3();
        assertEquals("3242606", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day3();
        assertEquals("230", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day3();
        assertEquals("4856080", day.solveTaskPart2());
    }

}