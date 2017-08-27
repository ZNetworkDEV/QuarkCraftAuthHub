/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.auth;

import net.quarkcraft.auth.events.Events;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreAuth extends JavaPlugin {
	private static CoreAuth instance;

	public void onEnable() {
		instance = this;
		this.getServer().getPluginManager().registerEvents(new Events(), this);
	}

	public void onDisable() {
	}

	public static CoreAuth getInstance() {
		return instance;
	}
}