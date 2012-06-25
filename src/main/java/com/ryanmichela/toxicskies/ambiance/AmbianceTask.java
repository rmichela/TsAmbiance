package com.ryanmichela.toxicskies.ambiance;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class AmbianceTask implements Runnable {
    private int SECONDS_BETWEEN_RESETS = 30;
    private World world;

    public AmbianceTask(World world) {
        this.world = world;
    }

    public void run() {
        Bukkit.getLogger().info("Setting ambiance " + world.getTime());

        world.setStorm(true);
        world.setWeatherDuration(AmbiancePlugin.TICKS_PER_SECOND * SECONDS_BETWEEN_RESETS + 5);
        world.setThundering(true);
        world.setThunderDuration(AmbiancePlugin.TICKS_PER_SECOND * SECONDS_BETWEEN_RESETS + 5);
        world.setTime(6000 - 300); // Noon - 15 seconds of time

        if (AmbiancePlugin.getInstance().isEnabled()) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(AmbiancePlugin.getInstance(), this, AmbiancePlugin.TICKS_PER_SECOND * SECONDS_BETWEEN_RESETS);
        }
    }
}