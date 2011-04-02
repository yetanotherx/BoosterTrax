package yetanotherx.bukkitplugin.BoosterTrax;

//Bukkit imports
import org.bukkit.event.Event;
import org.bukkit.event.vehicle.VehicleListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

//Java imports
import java.util.logging.Logger;

/*
 * BoosterTrax Version 1.0 - Boost minecarts easily
 * Copyright (C) 2011 Yetanotherx <yetanotherx -a--t- gmail -dot- com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class BoosterTrax extends JavaPlugin {

    /**
     * Minecart listener class
     */
    VehicleListener vehicleListener = new BoosterTraxVehicleListener();

    /**
     * Logger magic
     */
    public static final Logger log = Logger.getLogger("Minecraft");

    /**
     * Outputs a message when disabled
     */
    public void onDisable() {
	log.info( "[" + this.getDescription().getName() + "]" + " Plugin disabled. (version" + this.getDescription().getVersion() + ")");
    }

    /**
     * Enables the plugin
     */
    public void onEnable() {

	PluginManager pm = getServer().getPluginManager();

	//Event updates the database file on quit
	pm.registerEvent(Event.Type.VEHICLE_UPDATE, vehicleListener, Event.Priority.Normal, this);

	//Print that the plugin has been enabled!
	log.info( "[" + this.getDescription().getName() + "]" + " Plugin enabled! (version" + this.getDescription().getVersion() + ")");

    }

}
