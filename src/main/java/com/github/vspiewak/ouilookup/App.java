package com.github.vspiewak.ouilookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String... args) throws IOException, URISyntaxException {

        if (args.length < 1) {

            log.info("You must provide a mac address in parameter");
            System.exit(1);

        }

        String macAddress = args[0];
        String manufacturer = OUILookup.ouiLookup(OUILookup.formatForOuiLookup(macAddress));

        log.info("{}", manufacturer);

    }

}
