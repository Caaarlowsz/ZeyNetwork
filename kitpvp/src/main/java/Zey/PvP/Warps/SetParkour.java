package Zey.PvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Main.Main;

public class SetParkour implements CommandExecutor {
	public static Main plugin;

	public SetParkour(final Main main) {
		SetParkour.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("parkourset") && sender instanceof Player) {
			if (!sender.hasPermission("zey.pvp.set")) {
				final Player p = (Player) sender;
				p.sendMessage("§cVocê não tem permissão para isso.");
			}
			if (sender.hasPermission("zey.pvp.set")) {
				final Player p = (Player) sender;
				SetParkour.plugin.getConfig().set("parkour.x", (Object) p.getLocation().getX());
				SetParkour.plugin.getConfig().set("parkour.y", (Object) p.getLocation().getY());
				SetParkour.plugin.getConfig().set("parkour.z", (Object) p.getLocation().getZ());
				SetParkour.plugin.getConfig().set("parkour.pitch", (Object) p.getLocation().getPitch());
				SetParkour.plugin.getConfig().set("parkour.yaw", (Object) p.getLocation().getYaw());
				SetParkour.plugin.getConfig().set("parkour.world", (Object) p.getLocation().getWorld().getName());
				SetParkour.plugin.saveConfig();
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aWarp Parkour foi setada com sucesso");
			}
			return true;
		}
		return false;
	}
}
