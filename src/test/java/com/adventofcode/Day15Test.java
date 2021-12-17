package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day15Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day15();
        assertEquals("40", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day15();
        assertEquals("687", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day15();
        assertEquals("315", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day15();
        assertEquals("2957", day.solveTaskPart2());
    }

}