package com.kiritokirigami5.events;

import com.kiritokirigami5.files.Config;
import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CustomEvent implements Listener {

    @EventHandler
    public void getBock(CustomBlockPlaceEvent event) {
        FileConfiguration config = Config.get();

        Location loc = event.getBlock().getLocation();

        Player player = event.getPlayer();

        CustomBlock customBlock = CustomBlock.getInstance(event.getNamespacedID());

        if (customBlock != null) {
            for (String str : config.getConfigurationSection("Blocks").getKeys(false)) {
                if (!str.equals(event.getNamespacedID())) return;
                CustomBlock FinalBlock = CustomBlock.getInstance(config.getString("Blocks." + str + "." + event.getPlacedAgainst().getFace(event.getBlock()).toString()));
                FinalBlock.place(loc);
                FinalBlock.playPlaceSound();
                if (!(player.getGameMode() == GameMode.CREATIVE)) {
                    player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                }
                event.setCancelled(true);
            }
        }
    }
}