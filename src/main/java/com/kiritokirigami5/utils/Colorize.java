package com.kiritokirigami5.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Colorize {
    private final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    private String format(String msg) {
        Matcher match = pattern.matcher(msg);
        while (match.find()) {
            String hex = msg.substring(match.start(), match.end());
            msg = msg.replace(hex, net.md_5.bungee.api.ChatColor.of(hex)+"");
            match = pattern.matcher(msg);
        }
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String colorize(String msg) {
        return new Colorize().format(msg);
    }
}