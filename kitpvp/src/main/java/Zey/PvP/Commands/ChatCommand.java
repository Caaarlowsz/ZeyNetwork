package Zey.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Zey.PvP.Main.Main;

public class ChatCommand implements CommandExecutor, Listener {
	public static boolean c;

	static {
		ChatCommand.c = false;
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("chat")) {
			if (!p.hasPermission("zey.pvp.chatonoff")) {
				p.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}
			if (Args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " §7» §cErrado, utilize a sintaxe correta: /chat [Ligar/Desligar]");
				return true;
			}
			if (Args[0].equalsIgnoreCase("desligar")) {
				ChatCommand.c = true;
				Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §7» §7O chat do servidor foi §c§lDESLIGADO§7.");
			}
			if (Args[0].equalsIgnoreCase("ligar")) {
				ChatCommand.c = false;
				Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §7» §7O chat do servidor foi §a§lLIGADO§7.");
			}
		}
		return false;
	}

	@EventHandler
	public void naoFalarNoChatQuandoTiverOFF(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (!p.hasPermission("zey.pvp.falarchat") && ChatCommand.c) {
			e.setCancelled(true);
			p.sendMessage(
					String.valueOf(Main.prefix) + " §7» §cVocê não tem permissão para falar com o chat desativado.");
		}
	}
}
