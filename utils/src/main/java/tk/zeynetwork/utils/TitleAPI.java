package tk.zeynetwork.utils;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.spigotmc.ProtocolInjector.PacketTitle;
import org.spigotmc.ProtocolInjector.PacketTitle.Action;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class TitleAPI {

	public static void sendTitle(Player player, String title, String subtitle) {
		sendTitle(player, title);
		sendSubTitle(player, subtitle);
	}

	public static void sendTitle(Player player, String title) {
		sendTextPacket(player, Action.TITLE, title);
	}

	public static void sendSubTitle(Player player, String subtitle) {
		sendTextPacket(player, Action.SUBTITLE, subtitle);
	}

	public static void reset(Player player) {
		sendPacket(player, new PacketTitle(Action.RESET));
	}

	private static void sendTextPacket(Player player, Action action, String text) {
		PlayerConnection con = ((CraftPlayer) player).getHandle().playerConnection;
		if (con.networkManager.getVersion() >= 47)
			con.sendPacket(new PacketTitle(action, ChatSerializer.a("'" + text + "'")));
	}

	private static void sendPacket(Player player, PacketTitle packet) {
		PlayerConnection con = ((CraftPlayer) player).getHandle().playerConnection;
		if (con.networkManager.getVersion() >= 47)
			con.sendPacket(packet);
	}
}