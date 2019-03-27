package com.araltiparmak.tictactoe.player;

import com.araltiparmak.tictactoe.config.Configuration;

import java.util.Arrays;
import java.util.List;

public final class PlayerFactory {

    private List<Player> players;
    private Configuration conf;

    public List<Player> getPlayers() {
        return players;
    }

    public PlayerFactory(Configuration conf) {
        this.conf = conf;
        players = Arrays.asList(createAI(), createHuman1(), createHuman2());
    }

    private AI createAI() {
        return new AI(conf.getAiChar());
    }

    private Human createHuman1() {
        return new Human(conf.getHuman1Char());
    }

    private Human createHuman2() {
        return new Human(conf.getHuman2Char());
    }

}
