/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.auth.utils;

import java.lang.reflect.Field;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Utilidades {
	public static String Color(String color) {
		return ChatColor.translateAlternateColorCodes('&', color);
	}

	public static void SendTabList(Player player) {
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
		IChatBaseComponent header = ChatSerializer.a("{text:\"" + ChatColor.DARK_PURPLE + "Quark"
				+ ChatColor.LIGHT_PURPLE + "Craft" + "\n" + ChatColor.GRAY + "¡AuthHub!" + "\"}");
		IChatBaseComponent footer = ChatSerializer
				.a("{text:\"" + ChatColor.AQUA + "IP: " + ChatColor.YELLOW + "mc.quarkcraft.net" + "\n" + ChatColor.AQUA
						+ "Tienda: " + ChatColor.YELLOW + "tienda.mc.quarkcraft.net" + "\"}");

		try {
			Field e1 = packet.getClass().getDeclaredField("a");
			e1.setAccessible(true);
			e1.set(packet, header);
			Field b = packet.getClass().getDeclaredField("b");
			b.setAccessible(true);
			b.set(packet, footer);
		} catch (Exception arg5) {
			arg5.printStackTrace();
		}

		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}
}