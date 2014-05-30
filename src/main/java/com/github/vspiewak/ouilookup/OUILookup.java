package com.github.vspiewak.ouilookup;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * //http://standards.ieee.org/develop/regauth/oui/oui.txt
 */
public class OUILookup {

    private static Pattern hexLinePattern = Pattern.compile("([A-F0-9]{2}[-][A-F0-9]{2}[-][A-F0-9]{2})\\s+\\(hex\\)\\s+(.*)");
    private static Map<String, String> ouiMap = new HashMap<String, String>();

    static {
        try {
            InputStream is = OUILookup.class.getClassLoader().getResourceAsStream("oui.txt");
            Scanner scan = new Scanner(is);
            scan.useDelimiter("\n");
            while (scan.hasNext()) {
                String line = scan.next().trim();
                if (line.length() > 0) {
                    Matcher matcher = hexLinePattern.matcher(line);
                    if(matcher.matches()) {
                        String hex = matcher.group(1).replaceAll("-", ":").toLowerCase();
                        String manufacturer = matcher.group(2);
                        ouiMap.put(hex, manufacturer);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String formatForOuiLookup(String macAddress) {
        return macAddress.replaceAll("-", ":").toLowerCase();
    }

    public static String ouiLookup(String macAddress) {
        String key = macAddress.substring(0, 8);
        return ouiMap.get(key);
    }

}
