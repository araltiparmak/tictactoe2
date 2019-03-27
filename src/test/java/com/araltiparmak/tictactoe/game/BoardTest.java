package com.araltiparmak.tictactoe.game;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BoardTest {

    private static String[][] gridSize3 = {{"X", "X", "Y"}, {"O", "O", "X"}, {"X", null, "X"}};

    Random random = new Random();
    Board board;
    int size = 3;
    int randomX;
    int randomY;
    Point randomPoint;

    @Before
    public void setUp() {
        board = new Board(size);
        randomX = random.nextInt(size);
        randomY = random.nextInt(size);
        randomPoint = new Point(randomX, randomY);
        randomPoint.setCharacter("O");
    }

    @Test
    public void move() {
        board.move(randomPoint);
        assertEquals(randomPoint.getCharacter(), board.getGrid()[randomX][randomY]);
        assertEquals(size * size - 1, board.getBlankPoints().size());
    }

    @Test
    public void isWin() {
        Board board = new Board(gridSize3);
        Point p = new Point(2, 1, "X");
        board.move(p);
        assertTrue(board.isWin(p.getX(), p.getY()));

        board = new Board(gridSize3);
        p = new Point(2, 1, "O");
        board.move(p);
        assertFalse(board.isWin(p.getX(), p.getY()));
    }

    @Test
    public void isDraw() {
        assertEquals(board.getBlankPoints().size() == 0, board.isDraw());

        Board board = new Board(gridSize3);
        Point p = new Point(2, 1, "O");
        board.move(p);
        assertTrue(board.isDraw());

        p = new Point(2, 1, "X");
        board.move(p);
        assertFalse(board.isDraw());
    }

    @Test
    public void isGameOver() {
        assertTrue(!board.isGameOver());
    }

    @Test
    public void isPositionBlank() {
        assertTrue(board.isPositionBlank(new Point(randomX, randomY)));
        board.move(randomPoint);
        assertFalse(board.isPositionBlank(new Point(randomX, randomY)));
    }

    @Test
    public void isPositionValid() {
        assertFalse(board.isPositionValid(new Point(-1, 0)));
        assertFalse(board.isPositionValid(new Point(0, -1)));
        assertFalse(board.isPositionValid(new Point(size, size)));
        assertTrue(board.isPositionValid(new Point(0, 0)));
        assertTrue(board.isPositionValid(new Point(randomX, randomY)));
        assertTrue(board.isPositionValid(new Point(size - 1, size - 1)));
    }

}