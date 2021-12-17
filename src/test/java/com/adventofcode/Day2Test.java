package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day2();
        assertEquals("150", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day2();
        assertEquals("1989265", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day2();
        assertEquals("900", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day2();
        assertEquals("2089174012", day.solveTaskPart2());
    }

}