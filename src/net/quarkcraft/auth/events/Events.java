/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.auth.events;

import net.quarkcraft.auth.utils.Utilidades;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {
	@EventHandler
	public void PChat(AsyncPlayerChatEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void PJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setMaxHealth(2.0D);
		player.setHealth(2.0D);
		player.setFoodLevel(20);
		Utilidades.SendTabList(player);
		
		Location location = new Location(Bukkit.getWorld("Lobby") , -69.305 , 86.0 , -8.505);
		
		player.teleport(location);
	}

	@EventHandler
	public void feed(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void PDamage(EntityDamageEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void Breka2(BlockBreakEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void Breakk(BlockPlaceEvent event) {
		event.setCancelled(true);
	}
}