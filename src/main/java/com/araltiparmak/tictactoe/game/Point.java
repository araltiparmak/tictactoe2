package com.araltiparmak.tictactoe.game;

public final class Point {

    private int x;
    private int y;
    private String character;

    public void setCharacter(String character) {
        this.character = character;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, String character) {
        this.x = x;
        this.y = y;
        this.character = character;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCharacter() {
        return character;
    }

    public String getUniquKey() {
        return x + "," + y;
    }

    public static String getLabel(int x, int y) {
        return "(" + x + "," + y + ")";
    }

    public String getLabel() {
        return "(" + x + "," + y + ")";
    }

    public static String getUniqueKey(int x, int y) {
        return x + "," + y;
    }
}
