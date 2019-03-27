package com.araltiparmak.tictactoe.helper;

import com.araltiparmak.tictactoe.game.Point;

import java.util.Set;

public final class AIDecisionMaker {
    public Point makeDecision(Set<String> blankPoints) {

        String s = blankPoints.iterator().next();
        int x = Integer.parseInt(s.split(",")[0]);
        int y = Integer.parseInt(s.split(",")[1]);
        return new Point(x, y);
    }
}
