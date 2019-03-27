package com.araltiparmak.tictactoe.player;

import com.araltiparmak.tictactoe.helper.AIDecisionMaker;
import com.araltiparmak.tictactoe.game.Point;

import java.util.Set;

public final class AI extends Player {

    public AI(String character) {
        super(character);
    }

    @Override
    public Point play(Set<String> blankPoints) {
        AIDecisionMaker decisionMaker = new AIDecisionMaker();
        Point p = decisionMaker.makeDecision(blankPoints);
        p.setCharacter("Y");
        System.out.format("Player of %s (AI) has played %s%n%n", character, p.getLabel());
        return p;
    }

}
