package Zey.PvP.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Zey.PvP.Cassino.ApostasListener;

public class MenuGeral1 implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, "§7» §e§lMENU");

		final ItemStack event458 = new ItemStack(Material.EMERALD);
		final ItemMeta eventv2 = event458.getItemMeta();
		eventv2.setDisplayName("§e§lLOJA");
		event458.setItemMeta(eventv2);
		inv.setItem(12, event458);

		final ItemStack event459 = new ItemStack(Material.PAPER);
		final ItemMeta eventv3 = event459.getItemMeta();
		eventv3.setDisplayName("§e§lPERFIL");
		event459.setItemMeta(eventv3);
		inv.setItem(13, event459);

		final ItemStack event460 = new ItemStack(Material.GOLD_INGOT);
		final ItemMeta eventv4 = event460.getItemMeta();
		eventv4.setDisplayName("§e§lAPOSTAS");
		event460.setItemMeta(eventv4);
		inv.setItem(14, event460);

		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta vidrox = vidro.getItemMeta();
		vidrox.setDisplayName("§6§lZey§f§lPvP");
		vidro.setItemMeta(vidrox);
		inv.setItem(0, vidro);
		inv.setItem(1, vidro);
		inv.setItem(2, vidro);
		inv.setItem(3, vidro);
		inv.setItem(4, vidro);
		inv.setItem(5, vidro);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro);
		inv.setItem(8, vidro);
		inv.setItem(9, vidro);
		inv.setItem(10, vidro);
		inv.setItem(11, vidro);
		inv.setItem(15, vidro);
		inv.setItem(16, vidro);
		inv.setItem(17, vidro);
		inv.setItem(18, vidro);
		inv.setItem(19, vidro);
		inv.setItem(20, vidro);
		inv.setItem(21, vidro);
		inv.setItem(22, vidro);
		inv.setItem(23, vidro);
		inv.setItem(24, vidro);
		inv.setItem(25, vidro);
		inv.setItem(26, vidro);

		/*
		 * if (!p.hasPermission("cmd.admin")) { final ItemStack magma = new
		 * ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14); final ItemMeta magmam =
		 * magma.getItemMeta(); magmam.setDisplayName("§c§lBLOQUEADO"); final
		 * ArrayList<String> desc = new ArrayList<String>();
		 * magmam.setLore((List<String>)desc); magma.setItemMeta(magmam);
		 * inv.setItem(14, magma); } else if (p.hasPermission("cmd.admin")) { final
		 * ItemStack magma = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
		 * final ItemMeta magmam = magma.getItemMeta();
		 * magmam.setDisplayName("§a§lADMINISTRAÇÃO"); final ArrayList<String>
		 * desc = new ArrayList<String>(); magmam.setLore((List<String>)desc);
		 * magma.setItemMeta(magmam); inv.setItem(14, magma); }
		 */

		for (int descpyro2 = (inv.getContents()).length, metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("warps")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7» §e§lMENU") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			/*
			 * if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(
			 * "§a§lADMINISTRAÇÃO")) { e.setCancelled(true); p.closeInventory();
			 * MenuAdm.guiKits(p); p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
			 * return; }
			 */

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lAPOSTAS")) {
				e.setCancelled(true);
				p.closeInventory();
				ApostasListener.Seletor(p.getPlayer());
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lKITS")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuKits.GuiKit(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lPERFIL")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuPerfil.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lWARPS")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuWarps.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lLOJA")) {
				e.setCancelled(true);
				p.closeInventory();
				MenuLojaVips.guiKits(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
			}
		}
	}

	public static void ir(final Player p, final String string) {
	}
}
