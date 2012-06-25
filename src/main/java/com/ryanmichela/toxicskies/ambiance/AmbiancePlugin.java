package com.ryanmichela.toxicskies.ambiance;

import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AmbiancePlugin extends JavaPlugin {
    public static int TICKS_PER_SECOND = 20;
    public static Plugin instance;

    public AmbiancePlugin() {
        instance = this;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        Configuration config = getConfig();
        for (String worldName : config.getStringList("AffectedWorlds")) {
            getLogger().info("Adding ambiance to " + worldName);
            World world = getServer().getWorld(worldName);
            AmbianceTask task = new AmbianceTask(world);
            getServer().getScheduler().scheduleSyncDelayedTask(this, task);
        }
    }

    static Plugin getInstance() {
        return instance;
    }
}
