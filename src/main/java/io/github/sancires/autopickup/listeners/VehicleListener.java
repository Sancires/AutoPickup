package io.github.sancires.autopickup.listeners;

import io.github.sancires.autopickup.AutoPickup;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;

public class VehicleListener implements Listener {

    private final AutoPickup plugin;

    public VehicleListener(AutoPickup plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onExitVehicle(VehicleExitEvent exitEvent) {
        Vehicle vehicle = exitEvent.getVehicle();
        if (plugin.cv.enableBoatPickup()) {
            if (vehicle.getType() == EntityType.BOAT) {
                if (exitEvent.getExited() instanceof Player
                        && !vehicle.isDead() && vehicle.getPassengers().size() == 1
                        && ((Player) exitEvent.getExited()).getInventory().firstEmpty() != -1
                        && ((Player) exitEvent.getExited()).getGameMode() != GameMode.CREATIVE) {
                    vehicle.remove();
                    Material boat;
                    switch (((Boat) vehicle).getWoodType()) {
                        case BIRCH:
                            boat = Material.BIRCH_BOAT;
                            break;
                        case JUNGLE:
                            boat = Material.JUNGLE_BOAT;
                            break;
                        case ACACIA:
                            boat = Material.ACACIA_BOAT;
                            break;
                        case REDWOOD:
                            boat = Material.SPRUCE_BOAT;
                            break;
                        case DARK_OAK:
                            boat = Material.DARK_OAK_BOAT;
                            break;
                        default:
                            boat = Material.OAK_BOAT;
                            break;
                    }
                    ((Player) exitEvent.getExited()).getInventory().addItem(new ItemStack(boat));
                }
            }
        }
        if (plugin.cv.enableMinecartPickup()) {
            if (vehicle.getType() == EntityType.MINECART) {
                if (exitEvent.getExited() instanceof Player
                        && !vehicle.isDead() && vehicle.getPassengers().size() == 1
                        && ((Player) exitEvent.getExited()).getInventory().firstEmpty() != -1
                        && ((Player) exitEvent.getExited()).getGameMode() != GameMode.CREATIVE) {
                    vehicle.remove();
                    ((Player) exitEvent.getExited()).getInventory().addItem(new ItemStack(Material.MINECART));
                }
            }
        }
    }
}
