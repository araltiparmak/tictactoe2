package com.araltiparmak.tictactoe.game;

import com.araltiparmak.tictactoe.config.Configuration;
import com.araltiparmak.tictactoe.player.Player;
import com.araltiparmak.tictactoe.player.PlayerFactory;

import java.util.List;
import java.util.Random;

public final class TicTacToe {

    Configuration conf = new Configuration();
    private Board board;
    private List<Player> players;
    private int size;

    public TicTacToe() {
        size = conf.getSizeOfPlayGround();
        board = new Board(size);
        players = new PlayerFactory(conf).getPlayers();
    }

    public void start() {
        board.showGrid();
        int i = getRandomPlayerIndex();
        while (!board.isGameOver()) {
            nextMove(i++);
        }
    }

    private void nextMove(int i) {
        Player player = getNextPlayer(i);
        while (true) {
            Point p = player.play(board.getBlankPoints());
            if (checkPosition(board, p)) {
                board.move(p);
                break;
            }
        }
    }

    private boolean checkPosition(Board board, Point p) {
        if (!board.isPositionValid(p)) {
            System.out.format("Please enter a valid x,y position.%n");
            return false;
        }
        if (!board.isPositionBlank(p)) {
            System.out.format("This position %s has already filled! Try another.", p.getLabel());
            return false;
        }
        return true;
    }

    private int getRandomPlayerIndex() {
        Random r = new Random();
        return r.nextInt(players.size());
    }

    private Player getNextPlayer(int i) {
        return players.get(i % players.size());
    }

}
