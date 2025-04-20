package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

public class AppTest {
    private Sqrt sqrt;

    @BeforeEach
    public void setUp() {
        sqrt = new Sqrt(4.0);
    }

    @Test
    public void testAverage() {
        assertEquals(13.0, sqrt.average(13.0, 13.0), 1e-4);
        assertEquals(3.0, sqrt.average(1.0, 5.0), 1e-4);
        assertEquals(9.0, sqrt.average(12.0, 6.0), 1e-4);
    }

    @Test
    public void testGood() {
        assertTrue(sqrt.good(3.0, 9.0));
        assertFalse(sqrt.good(3.0, 4.0));
    }

    @Test
    public void testGoodWithSmallGuessAndX() {
        //sqrt = new Sqrt(0.0001);
        assertTrue(sqrt.good(0.001, 0.000001));
        assertFalse(sqrt.good(0.002, 0.000001));
    }

    @Test
    public void testImprove() {
        assertEquals(2.0, sqrt.improve(2.0, 4.0), 1e-4);
        assertEquals(2.5, sqrt.improve(1.0, 4.0), 1e-4);
    }

    @Test
    public void testIterWithGood() {
        assertEquals(3.0, sqrt.iter(3.0, 9.0), 1e-4);
    }

    @Test
    public void testIterWithNotGood() {
        assertNotEquals(2.0, sqrt.iter(1.0, 3.0), 1e-4);
        assertEquals(2.0, sqrt.iter(1.0, 4.0), 1e-4);
    }

    @Test
    public void testIterWithLargeGuessAndX() {
        assertEquals(1000.0, sqrt.iter(1000.0, 1000000.0), 1e-4);
        assertEquals(1000.0, sqrt.iter(1.0, 1000000.0), 1e-4);
    }

    @Test
    public void testCalcWithFour() {
        assertEquals(2.0, sqrt.calc(), 1e-4);
    }

    @Test
    public void testCalcWithNine() {
        sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), 1e-4);
    }

    @Test
    public void testCalcWithThirteen() {
        sqrt = new Sqrt(13.0);
        assertEquals(Math.sqrt(13.0), sqrt.calc(), 1e-4);
    }

    @Test
    public void testCalcWithZero() {
        sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), 1e-4);
    }

    @Test
    public void testCalcWithOne() {
        sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 1e-4);
    }

    @Test
    public void testCalcWithNegativeValue() {
        sqrt = new Sqrt(-4.0);
        assertThrows(IllegalArgumentException.class, () -> {
            sqrt.calc();
        });
    }

}

