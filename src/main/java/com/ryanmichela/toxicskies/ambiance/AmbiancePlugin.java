package com.ryanmichela.toxicskies.ambiance;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class AmbiancePlugin extends JavaPlugin {


    @Override
    public void onEnable() {
        World world = getServer().getWorld("world");
        world.setStorm(true);
        world.setWeatherDuration(200);
        world.setThundering(true);
        world.setThunderDuration(200);
    }

    @Override
    public void onDisable() {
        super.onDisable();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
