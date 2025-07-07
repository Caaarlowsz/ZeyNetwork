package Zey.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import Zey.PvP.Main.Main;

public class PingCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String c, final String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			final int ping = ((CraftPlayer) p).getHandle().ping;
			if (c.equalsIgnoreCase("ping")) {
				if (args.length == 0) {
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Seu ping atual é de §a§l" + ping + " §7ms");
				} else if (p.getServer().getPlayer(args[0]) != null) {
					final String player2 = args[0];
					final Player target = Bukkit.getServer().getPlayer(args[0]);
					final int ping2 = ((CraftPlayer) target).getHandle().ping;
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §7O jogador(a): §e" + player2
							+ " §7está com o ping atual de: §a§l" + ping2 + " §7ms");
				} else {
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §cEste jogador(a) está offline ou não existe.");
				}
			}
		}
		return false;
	}
}
