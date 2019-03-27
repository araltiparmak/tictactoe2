package com.araltiparmak.tictactoe.helper;

import com.araltiparmak.tictactoe.game.Point;

import java.util.Scanner;

public final class InputReader {

    public Point read() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            if (s.matches("\\d+,\\d+")) {
                int x = Integer.parseInt(s.split(",")[0]);
                int y = Integer.parseInt(s.split(",")[1]);
                return new Point(x, y);
            } else {
                System.out.format("Please enter a valid x,y position.%n");
            }
        }
    }

}
