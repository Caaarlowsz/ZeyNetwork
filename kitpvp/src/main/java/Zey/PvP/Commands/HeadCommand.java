package Zey.PvP.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import Zey.PvP.Main.Main;

public class HeadCommand implements CommandExecutor {
	Main main;

	public HeadCommand(Main plugin) {
		plugin = this.main;
	}

	public HeadCommand() {
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cApenas jogadores podem usar isso.");
			return true;
		}
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(
						String.valueOf(Main.PREFIX) + " §7» §cErrado, utilize a sintaxe correta: /head [Jogador(a)]");
			}
			if (args.length != 0 && args.length == 1) {
				if (p.hasPermission("zey.pvp.head")) {
					final ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
					skullItem.setDurability((short) 3);
					final SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
					skullMeta.setOwner(args[0]);
					skullItem.setItemMeta((ItemMeta) skullMeta);
					p.getInventory().addItem(new ItemStack[] { skullItem });
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aHead adicionada ao seu inventario.");
				} else {
					p.sendMessage("§cVocê não tem permissão para isso.");
				}
			}
		}
		return false;
	}
}
