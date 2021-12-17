package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day16Test {

    @Test
    public void testSolveExamplePart1() {
        var day = new Day16();
        assertEquals("31", day.solveExamplePart1());
    }

    @Test
    public void testSolveTaskPart1() {
        var day = new Day16();
        assertEquals("895", day.solveTaskPart1());
    }

    @Test
    public void testSolveExamplePart2() {
        var day = new Day16();
        assertEquals("54", day.solveExamplePart2());
    }

    @Test
    public void testSolveTaskPart2() {
        var day = new Day16();
        assertEquals("1148595959144", day.solveTaskPart2());
    }

}