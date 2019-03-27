package com.araltiparmak.tictactoe.player;

import com.araltiparmak.tictactoe.game.Point;

import java.util.Set;

public abstract class Player {

    protected String character;

    public Player(String character) {
        this.character = character;
    }

    public Point play(Set<String> blankPoints) {
        return null;
    }

}
