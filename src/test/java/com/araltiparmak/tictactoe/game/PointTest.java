package com.araltiparmak.tictactoe.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    int x = 1;
    int y = 2;
    Point p;

    @Before
    public void setUp() {
        p = new Point(x, y);
    }

    @Test
    public void getLabel() {
        assertEquals(p.getLabel(), "(" + x + "," + y + ")");
    }

    @Test
    public void getUniqueKey() {
        assertEquals(p.getUniquKey(), x + "," + y);
    }
}