package com.kiritokirigami5.utils;

import org.bukkit.Bukkit;

public class Logger {
    public Logger() {
    }

    public static void log(LogLevel level, String message, Object... args) {
        if (message != null) {
            switch(level) {
                case ERROR:
                    if (args != null) {
                        Bukkit.getConsoleSender().sendMessage(Colorize.colorize("&c[ERROR]&f " + String.format(message, args)));
                        return;
                    }

                    Bukkit.getConsoleSender().sendMessage(Colorize.colorize("&c[ERROR]&f " + message));
                    break;
                case WARN:
                    Bukkit.getConsoleSender().sendMessage(Colorize.colorize("&e[WARN]&f " + message));
                    break;
                case INFO:
                    Bukkit.getConsoleSender().sendMessage(Colorize.colorize("&a[INFO]&f " + message));
                    break;
            }
        }

    }

    public enum LogLevel {
        ERROR,
        WARN,
        INFO;

        LogLevel() {
        }
    }
}
