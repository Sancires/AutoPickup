package cyou.paul.autopickup;

import cyou.paul.autopickup.listeners.VehicleListener;
import cyou.paul.autopickup.util.ConfigValues;
import cyou.paul.autopickup.util.LogMessages;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@SuppressWarnings("ResultOfMethodCallIgnored")

public final class AutoPickup extends JavaPlugin {

    public ConfigValues cv;
    public LogMessages lm;

    @Override
    public void onEnable() {
        // Register util classes
        registerUtil();
        // Configuration
        registerConfig();
        // Register listeners
        registerListeners();

    }

    public void registerUtil() {
        this.cv = new ConfigValues(this);
        this.lm = new LogMessages(this);
    }

    public void registerConfig() {
        if (cv.configVersion() != 2) {
            lm.outdatedConfig();
            File configFile = new File(getDataFolder(), "config.yml");
            configFile.renameTo(new File(this.getDataFolder(), "config-old.yml"));
        }
        this.saveDefaultConfig();
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new VehicleListener(this), this);
    }
}
