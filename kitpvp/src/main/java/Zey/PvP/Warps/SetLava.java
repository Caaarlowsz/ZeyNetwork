package Zey.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Main.Main;

public class SetLava implements CommandExecutor {
	public static Main plugin;

	public SetLava(final Main main) {
		SetLava.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("challengeset") && sender instanceof Player) {
			if (!sender.hasPermission("zey.pvp.set")) {
				final Player p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}
			if (sender.hasPermission("zey.pvp.set")) {
				final Player p = (Player) sender;
				SetLava.plugin.getConfig().set("lava.x", (Object) p.getLocation().getX());
				SetLava.plugin.getConfig().set("lava.y", (Object) p.getLocation().getY());
				SetLava.plugin.getConfig().set("lava.z", (Object) p.getLocation().getZ());
				SetLava.plugin.getConfig().set("lava.pitch", (Object) p.getLocation().getPitch());
				SetLava.plugin.getConfig().set("lava.yaw", (Object) p.getLocation().getYaw());
				SetLava.plugin.getConfig().set("lava.world", (Object) p.getLocation().getWorld().getName());
				SetLava.plugin.saveConfig();
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aWarp Challenge foi setada com sucesso");
			}
			return true;
		}
		return false;
	}
}
