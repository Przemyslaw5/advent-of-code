package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day7();
        assertEquals("37", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day7();
        assertEquals("323647", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day7();
        assertEquals("168", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day7();
        assertEquals("87640209", day.solveTaskPart2());
    }

}