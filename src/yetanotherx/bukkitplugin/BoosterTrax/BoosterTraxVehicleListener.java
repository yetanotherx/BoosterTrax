package yetanotherx.bukkitplugin.BoosterTrax;

import org.bukkit.Location;
import org.bukkit.entity.Minecart;
import org.bukkit.event.vehicle.VehicleListener;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import org.bukkit.util.Vector;

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
public class BoosterTraxVehicleListener extends VehicleListener {
	
	public void onVehicleUpdate(VehicleUpdateEvent event) {
		
		if (event.getVehicle() instanceof Minecart) {
			
			Minecart minecart = (Minecart) event.getVehicle();

			Location location = minecart.getLocation();
			location.setY( location.getY() - 1 );
			
			double multiplier = 1.0;
			
			switch( minecart.getWorld().getBlockTypeIdAt(location) ) {
			case 41: //Gold block
				multiplier = 9.0;
				break;
			case 57: //Diamond block
				multiplier = 16.0;
				break;
			}

			if( multiplier != 1.0 ) {
				
				if( minecart.getWorld().getBlockAt(location).isBlockPowered() ) {
					//Disable with redstone
					return;
				}

				Vector velocity = minecart.getVelocity();
				double x = velocity.getX();
				double y = velocity.getY();
				double z = velocity.getZ();
				
				if ( 1E150D / multiplier > Math.abs(x)) {
					x = x * multiplier;
				}
				if ( 1E150D / multiplier > Math.abs(y)) {
					y = y * multiplier;
				}
				if ( 1E150D / multiplier > Math.abs(z)) {
					z = z * multiplier;
				}
				
				Vector newvelocity = new Vector( x, y, z );
				minecart.setVelocity( newvelocity );
			
			}
			
		}
		
	}
	

}
