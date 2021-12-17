package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day8Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day8();
        assertEquals("26", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day8();
        assertEquals("255", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day8();
        assertEquals("61229", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day8();
        assertEquals("982158", day.solveTaskPart2());
    }

}