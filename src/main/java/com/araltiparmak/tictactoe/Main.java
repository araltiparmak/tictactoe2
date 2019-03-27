package com.araltiparmak.tictactoe;

import com.araltiparmak.tictactoe.game.TicTacToe;

public final class Main {
    public static void main(String[] args) {

        System.out.format("Game begins. Have fun!%n");
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
    }
}
