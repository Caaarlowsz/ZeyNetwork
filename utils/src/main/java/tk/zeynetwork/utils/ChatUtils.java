package tk.zeynetwork.utils;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class ChatUtils {

	public static void runCommand(Player player, String message, String hoverMessage, String command) {
		TextComponent component = new TextComponent(message);
		component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent[] { new TextComponent(hoverMessage)}));
		component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
		player.spigot().sendMessage(component);
	}
}