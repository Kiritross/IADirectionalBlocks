/*
    ____   ____     .__   __                  _____  _________
    \   \ /   /____ |  |_/  |_ __ __  ______ /     \ \_   ___ \
     \   Y   // __ \|  |\   __\  |  \/  ___//  \ /  \/    \  \/
      \     /\  ___/|  |_|  | |  |  /\___ \/    Y    \     \____
       \___/  \_____>____/__| |____//______>____|__  /\________/

--+-------------------------------------------------------------+--
     VeltusMC© - Developed by VeltusMC - All Rights Reserved
--+-------------------------------------------------------------+--
 */

package com.kiritokirigami5;

import com.kiritokirigami5.commands.CommandManager;
import com.kiritokirigami5.utils.Logger;
import com.kiritokirigami5.utils.Register;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Logger.log(Logger.LogLevel.INFO, "VeltusMC© - Developed by VeltusMC - All Rights Reserved");
        Logger.log(Logger.LogLevel.INFO, "Official author: KiritoKirigami5");
        Logger.log(Logger.LogLevel.INFO, "Loading...");

        new Register().registerConfig();
        new Register().registerEvents();

        getCommand("iadb").setExecutor(new CommandManager());
    }

    @Override
    public void onDisable() {
        Logger.log(Logger.LogLevel.INFO, "Disabling...");
    }
}