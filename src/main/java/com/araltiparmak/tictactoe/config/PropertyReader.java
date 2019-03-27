package com.araltiparmak.tictactoe.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyReader {

    private final static String PROP_FILE_NAME = "game.properties";

    public static Properties getProps() throws IOException {
        Properties props = new Properties();
        InputStream stream = PropertyReader.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME);
        props.load(stream);
        return props;
    }
}
