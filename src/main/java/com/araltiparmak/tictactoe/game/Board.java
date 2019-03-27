package com.araltiparmak.tictactoe.game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Board {

    private String[][] grid;
    private int size;
    private boolean draw = false;
    private boolean win = false;
    private Set<String> blankPoints = new HashSet<>();

    public Set<String> getBlankPoints() {
        return blankPoints;
    }

    public String[][] getGrid() {
        return grid.clone();
    }

    public Board(int size) {
        this.size = size;
        this.grid = new String[size][size];
        setBlankPoints();
    }

    private void setBlankPoints() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                blankPoints.add(Point.getUniqueKey(i, j));
            }
        }
    }

    Board(String[][] grid) {
        setBlankPoints();
        this.size = grid.length;
        this.grid = grid;
    }

    public void move(Point p) {
        apply(p);
        showGrid();
        updateStatus(p.getX(), p.getY());
    }

    private void apply(Point p) {
        int x = p.getX();
        int y = p.getY();
        grid[x][y] = p.getCharacter();
        blankPoints.remove(p.getUniquKey());
    }

    private void updateStatus(int x, int y) {
        win = isWin(x, y);
        if (!win) {
            draw = isDraw();
        }
    }

    boolean isWin(int x, int y) {
        if (checkLine(x) || checkColumn(x, y) || checkDiag(x, y) || checkReverseDiag(x, y)) {
            System.out.format("Player of %s has won the game!%n", grid[x][y]);
            return true;
        }
        return false;
    }

    private boolean checkReverseDiag(int x, int y) {
        if (x + y != size - 1) {
            return false;
        }
        boolean checkWin = true;
        for (int i = 0; i < size; i++) {
            if (!grid[x][y].equals(grid[i][(size - 1) - i])) {
                checkWin = false;
                break;
            }
        }
        return checkWin;
    }

    private boolean checkDiag(int x, int y) {
        if (x != y) {
            return false;
        }
        boolean checkWin = true;
        for (int i = 0; i < size; i++) {
            if (!grid[x][x].equals(grid[i][i])) {
                checkWin = false;
                break;
            }
        }
        return checkWin;
    }

    private boolean checkColumn(int x, int y) {
        boolean checkWin = true;
        for (int i = 0; i < size; i++) {
            if (!grid[x][y].equals(grid[i][y])) {
                checkWin = false;
                break;
            }
        }
        return checkWin;
    }

    private boolean checkLine(int x) {
        String[] line = grid[x];
        return Arrays.stream(grid[x]).allMatch(e -> e != null && e.equals(line[0]));
    }

    public boolean isDraw() {
        if (blankPoints.size() == 0 && !win) {
            System.out.println("Game draw. No winner!");
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return win || draw;
    }

    public boolean isPositionBlank(Point p) {
        return blankPoints.contains(p.getUniquKey());
    }

    public boolean isPositionValid(Point p) {
        int x = p.getX();
        int y = p.getY();
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    public void showGrid() {
        System.out.println("------------------------------");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != null) {
                    System.out.print("  " + grid[i][j] + "  ");
                } else {
                    System.out.print(Point.getLabel(i, j));
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
        System.out.println("\n");
    }
}
