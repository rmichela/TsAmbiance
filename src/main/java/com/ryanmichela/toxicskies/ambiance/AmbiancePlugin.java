package com.ryanmichela.toxicskies.ambiance;

import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class AmbiancePlugin extends JavaPlugin {


    @Override
    public void onEnable() {
        saveDefaultConfig();

        Configuration config = getConfig();
        for (String worldName : config.getStringList("AffectedWorlds")) {
            getLogger().info("Adding ambiance to " + worldName);
            World world = getServer().getWorld(worldName);
            world.setStorm(true);
            world.setWeatherDuration(200);
            world.setThundering(true);
            world.setThunderDuration(200);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
