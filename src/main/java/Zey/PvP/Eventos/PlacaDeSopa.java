package Zey.PvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import Zey.PvP.Main.Main;

public class PlacaDeSopa implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public PlacaDeSopa(final Main main) {
		this.plugin = main;
	}

	public PlacaDeSopa() {
	}

	@EventHandler
	public void onSignChange(final SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("[sopa]")) {
			e.setLine(0, "§7-=-(+)-=-");
			e.setLine(1, "§e§l SOPAS ");
			e.setLine(2, "§e§l");
			e.setLine(3, "§7-=-(+)-=-");
		}
	}

	@EventHandler
	public void inv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack sopas = new ItemStack(Material.MUSHROOM_SOUP);
		final Inventory inve = Bukkit.getServer().createInventory((InventoryHolder) p, 36, "§e§lSOPAS");
		inve.setItem(0, sopas);
		inve.setItem(1, sopas);
		inve.setItem(2, sopas);
		inve.setItem(3, sopas);
		inve.setItem(4, sopas);
		inve.setItem(5, sopas);
		inve.setItem(6, sopas);
		inve.setItem(7, sopas);
		inve.setItem(8, sopas);
		inve.setItem(9, sopas);
		inve.setItem(10, sopas);
		inve.setItem(11, sopas);
		inve.setItem(12, sopas);
		inve.setItem(13, sopas);
		inve.setItem(14, sopas);
		inve.setItem(15, sopas);
		inve.setItem(16, sopas);
		inve.setItem(17, sopas);
		inve.setItem(18, sopas);
		inve.setItem(19, sopas);
		inve.setItem(20, sopas);
		inve.setItem(21, sopas);
		inve.setItem(22, sopas);
		inve.setItem(23, sopas);
		inve.setItem(24, sopas);
		inve.setItem(25, sopas);
		inve.setItem(26, sopas);
		inve.setItem(27, sopas);
		inve.setItem(28, sopas);
		inve.setItem(29, sopas);
		inve.setItem(30, sopas);
		inve.setItem(31, sopas);
		inve.setItem(32, sopas);
		inve.setItem(33, sopas);
		inve.setItem(34, sopas);
		inve.setItem(35, sopas);
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0 && lines[0].equals("§7-=-(+)-=-") && lines.length > 1 && lines[1].equals("§e§l SOPAS ")
					&& lines.length > 2 && lines[2].equals("§e§l") && lines.length > 3
					&& lines[3].equals("§7-=-(+)-=-")) {
				p.openInventory(inve);
			}
		}
	}

	@EventHandler
	public void onPlayerColor(final SignChangeEvent e) {
		if (e.getLine(0).contains("&")) {
			e.setLine(0, e.getLine(0).replace("&", "?"));
		}
		if (e.getLine(1).contains("&")) {
			e.setLine(1, e.getLine(1).replace("&", "?"));
		}
		if (e.getLine(2).contains("&")) {
			e.setLine(2, e.getLine(2).replace("&", "?"));
		}
		if (e.getLine(3).contains("&")) {
			e.setLine(3, e.getLine(3).replace("&", "?"));
		}
	}
}
