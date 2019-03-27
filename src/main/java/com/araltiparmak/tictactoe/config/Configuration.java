package com.araltiparmak.tictactoe.config;

import java.io.IOException;
import java.util.Properties;

public final class Configuration {

    private Properties props;
    private int sizeOfPlayGround;
    private String aiChar;
    private String human1Char;
    private String human2Char;

    public Configuration() {
        init();
    }

    public String getAiChar() {
        return aiChar;
    }

    public String getHuman1Char() {
        return human1Char;
    }

    public String getHuman2Char() {
        return human2Char;
    }

    public int getSizeOfPlayGround() {
        return sizeOfPlayGround;
    }

    private void init() {
        try {
            setFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setFields() throws IOException {
        props = PropertyReader.getProps();
        sizeOfPlayGround = Integer.parseInt(props.getProperty("sizeOfPlayGround"));
        aiChar = props.getProperty("aiChar");
        human1Char = props.getProperty("human1Char");
        human2Char = props.getProperty("human2Char");
    }

}
