package io.github.sancires.autopickup.util;

import io.github.sancires.autopickup.AutoPickup;

public class ConfigValues {

    private final AutoPickup plugin;
    public ConfigValues (AutoPickup plugin) {
        this.plugin = plugin;
    }

    // Ints <------------------------------------------------------------------------------------------------------->

    public int configVersion() {
        return plugin.getConfig().getInt("config-version-do-not-change");
    }

    // Booleans <--------------------------------------------------------------------------------------------------->

    public boolean enableBoatPickup() {
        return plugin.getConfig().getBoolean("boat-pickup.enabled");
    }

    public boolean enableMinecartPickup() {
        return plugin.getConfig().getBoolean("minecart-pickup.enabled");
    }

}
