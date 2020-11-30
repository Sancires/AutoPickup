package cyou.paul.autopickup.util;

import cyou.paul.autopickup.AutoPickup;

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
