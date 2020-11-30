package cyou.paul.autopickup.util;

import cyou.paul.autopickup.AutoPickup;

public class LogMessages {

    private final AutoPickup plugin;
    public LogMessages (AutoPickup plugin) {
        this.plugin = plugin;
    }

    public void outdatedConfig() {
        plugin.getServer().getLogger().warning
                ("Your config file is out of date! A new file will be created, and the old config will be renamed.\n" +
                        "You will need to copy your old config values to the updated file.");
    }

}
