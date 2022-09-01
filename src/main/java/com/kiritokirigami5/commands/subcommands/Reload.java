package com.kiritokirigami5.commands.subcommands;

import com.kiritokirigami5.commands.SubCommand;
import com.kiritokirigami5.files.Config;
import com.kiritokirigami5.utils.Colorize;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Reload extends SubCommand {
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reloads the plugin";
    }

    @Override
    public String getSyntax() {
        return "/iadb reload";
    }

    @Override
    public void perform(Player player, String[] args) {
        FileConfiguration config = Config.get();
        if (player.hasPermission(config.getString("Configuration.permissions.reload"))) {
            Config.reload();
            player.sendMessage(Colorize.colorize(config.getString("Messages.reload")));
        } else {
            player.sendMessage(Colorize.colorize(config.getString("Messages.no-permission")));
        }

    }
}
