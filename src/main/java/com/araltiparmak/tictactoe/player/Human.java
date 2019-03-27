package com.araltiparmak.tictactoe.player;

import com.araltiparmak.tictactoe.game.Point;
import com.araltiparmak.tictactoe.helper.InputReader;

import java.util.Set;

public final class Human extends Player {

    public Human(String character) {
        super(character);
    }

    @Override
    public Point play(Set<String> blankPoints) {
        System.out.format("Please enter a valid x,y position.%n");
        System.out.format("Player of %s, your turn:%n", character);
        InputReader reader = new InputReader();
        Point p = reader.read();
        p.setCharacter(character);
        System.out.format("Player of %s has played %s%n%n", character, p.getLabel());
        return p;
    }
}
