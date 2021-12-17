package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day13Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day13();
        assertEquals("17", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day13();
        assertEquals("753", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day13();
        assertEquals("0", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day13();
        assertEquals("HZLEHJRK", day.solveTaskPart2());
    }

}