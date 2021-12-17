package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day14Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day14();
        assertEquals("1588", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day14();
        assertEquals("3587", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day14();
        assertEquals("2188189693529", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day14();
        assertEquals("3906445077999", day.solveTaskPart2());
    }

}