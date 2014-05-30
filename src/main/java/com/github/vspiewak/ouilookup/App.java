package com.github.vspiewak.ouilookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String... args) throws IOException, URISyntaxException {

        log.info("OUILookup: {}", OUILookup.ouiLookup("10:dd:b1:c9:25:d1"));
        log.info("OUILookup: {}", OUILookup.ouiLookup("1c:3e:84:55:ea:b5"));

    }

}
