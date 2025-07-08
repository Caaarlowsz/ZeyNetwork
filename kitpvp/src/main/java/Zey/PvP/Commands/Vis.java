package Zey.PvP.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Main.Main;

public class Vis implements CommandExecutor {
	public static ArrayList<Player> emVis;

	static {
		Vis.emVis = new ArrayList<Player>();
	}

	public static boolean emInvisivel(final Player p) {
		return Vis.emVis.contains(p);
	}

	public static void addInvisivel(final Player p) {
		Vis.emVis.add(p);
	}

	public static void remoVisInvisivel(final Player p) {
		Vis.emVis.remove(p);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("vis")) {
			if (p.hasPermission("zey.pvp.vis")) {
				if (!emInvisivel(p)) {
					addInvisivel(p);
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Modo §8§lINVISIVEL§7 ativado");
					p.setGameMode(GameMode.CREATIVE);
					Player[] onlinePlayers;
					for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
						final Player todos = onlinePlayers[i];
						todos.hidePlayer(p);
					}
				} else {
					remoVisInvisivel(p);
					Player[] onlinePlayers2;
					for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
						final Player todos = onlinePlayers2[j];
						todos.showPlayer(p);
					}
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Modo §8§lINVISIVEL§7 desativado");
				}
			} else {
				p.sendMessage("§cVocê não tem permiss§o para isso.");
			}
		}
		return false;
	}
}
