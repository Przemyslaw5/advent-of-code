package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day4();
        assertEquals("4512", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day4();
        assertEquals("44088", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day4();
        assertEquals("1924", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day4();
        assertEquals("23670", day.solveTaskPart2());
    }

}