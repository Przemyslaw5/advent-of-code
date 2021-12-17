package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day1();
        assertEquals("7", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day1();
        assertEquals("1446", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day1();
        assertEquals("5", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day1();
        assertEquals("1486", day.solveTaskPart2());
    }

}