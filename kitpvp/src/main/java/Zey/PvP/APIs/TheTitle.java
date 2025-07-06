package Zey.PvP.APIs;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.spigotmc.ProtocolInjector;

import net.minecraft.server.v1_7_R4.ChatSerializer;

public class TheTitle implements Listener {

	private static int VERSION = 47;

	@EventHandler
	public void onPlayerColor(SignChangeEvent e) {
		if (e.getLine(0).contains("&")) {
			e.setLine(0, e.getLine(0).replace("&", "§"));
		}
		if (e.getLine(1).contains("&")) {
			e.setLine(1, e.getLine(1).replace("&", "§"));
		}
		if (e.getLine(2).contains("&")) {
			e.setLine(2, e.getLine(2).replace("&", "§"));
		}
		if (e.getLine(3).contains("&"))
			e.setLine(3, e.getLine(3).replace("&", "§"));
	}

	public static void sendTitle(Player p, String title) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
			return;
		}
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(
				ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(title)));
	}

	public static void sendSubTitle(Player p, String subtitle) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
			return;
		}
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(
				ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a("{\"text\": \"\"}").a(subtitle)));
	}

	public static void reset(Player p) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
			return;
		}
		((CraftPlayer) p).getHandle().playerConnection
				.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.RESET));
	}
}