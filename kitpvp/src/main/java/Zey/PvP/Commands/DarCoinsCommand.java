package Zey.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Main.Main;

public class DarCoinsCommand implements CommandExecutor {
	public static boolean isNumeric(final String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("darcoins")) {
			if (!p.hasPermission("zey.pvp.darcoins")) {
				p.sendMessage("§cVocê não tem permissão para isso.");
			} else {
				if (args.length == 0) {
					sender.sendMessage(String.valueOf(Main.NAME)
							+ " §7» §cErrado, utilize a sintaxe correta: /darcoins [jogador(a)] [quantidade]");
					return true;
				}
				final Player target = Bukkit.getPlayerExact(args[0]);
				if (target == null || !(target instanceof Player)) {
					sender.sendMessage(
							String.valueOf(Main.NAME) + " §7» §cEste jogador(a) está offline ou não existe.");
					return true;
				}
				if (isNumeric(args[1])) {
					final int coins = Integer.parseInt(args[1]);
					ZeyCoins.addMoney(target, coins);
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §aVocê deu ao jogador(a): §e" + target.getName()
							+ "§a " + coins + " ZeyCoins");
					target.sendMessage(String.valueOf(Main.NAME) + " §7» §aVocê recebeu do jogador(a): §e"
							+ p.getName() + "§a " + coins + " ZeyCoins");
				}
			}
		}
		return false;
	}
}
