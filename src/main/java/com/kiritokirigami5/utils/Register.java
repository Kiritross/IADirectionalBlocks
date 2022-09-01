package com.kiritokirigami5.utils;

import com.kiritokirigami5.Main;
import com.kiritokirigami5.events.CustomEvent;
import com.kiritokirigami5.files.Config;
import org.bukkit.plugin.PluginManager;

public class Register {

    public void registerConfig() {
        Main plugin = Main.getPlugin(Main.class);

        plugin.getConfig().options().copyDefaults();
        plugin.saveDefaultConfig();
        Config.setup();
        Config.get().options().copyDefaults(true);
        Config.save();
        Config.reload();
    }

    public void registerEvents() {
        PluginManager pm = Main.getPlugin(Main.class).getServer().getPluginManager();
        pm.registerEvents(new CustomEvent(), Main.getPlugin(Main.class));
    }
}