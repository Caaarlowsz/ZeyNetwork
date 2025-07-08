package Zey.PvP.Menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Zey.PvP.Main.Main;

public class MenuCabeças implements Listener {
	private static ArrayList<String> comchapeu;

	static {
		MenuCabeças.comchapeu = new ArrayList<String>();
	}

	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 54, "§7» §e§lCABEÇAS");
		final ItemStack event1234 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta eventv1234 = event1234.getItemMeta();
		eventv1234.setDisplayName("§c§lVOLTAR");
		event1234.setItemMeta(eventv1234);
		inv.setItem(0, event1234);

		final ItemStack ct = new ItemStack(Material.WORKBENCH);
		final ItemMeta ct2 = ct.getItemMeta();
		ct2.setDisplayName("§e§lCRAFTING TABLE");
		ct.setItemMeta(ct2);

		final ItemStack ft = new ItemStack(Material.FURNACE);
		final ItemMeta ft2 = ft.getItemMeta();
		ft2.setDisplayName("§e§lFORNALHA");
		ft.setItemMeta(ft2);

		final ItemStack vt = new ItemStack(Material.GLASS);
		final ItemMeta vt2 = vt.getItemMeta();
		vt2.setDisplayName("§e§lVIDRO");
		vt.setItemMeta(vt2);

		final ItemStack tt = new ItemStack(Material.TNT);
		final ItemMeta tt2 = tt.getItemMeta();
		tt2.setDisplayName("§e§lTNT");
		tt.setItemMeta(tt2);

		final ItemStack dt = new ItemStack(Material.DIAMOND_BLOCK);
		final ItemMeta dt2 = dt.getItemMeta();
		dt2.setDisplayName("§e§lDIAMANTE");
		dt.setItemMeta(dt2);

		final ItemStack st = new ItemStack(Material.MOB_SPAWNER);
		final ItemMeta st2 = st.getItemMeta();
		st2.setDisplayName("§e§lSPAWNER");
		st.setItemMeta(st2);

		final ItemStack bt = new ItemStack(Material.BOOKSHELF);
		final ItemMeta bt2 = bt.getItemMeta();
		bt2.setDisplayName("§e§lESTATANTE");
		bt.setItemMeta(bt2);

		final ItemStack cdt = new ItemStack(Material.ANVIL);
		final ItemMeta cdt2 = cdt.getItemMeta();
		cdt2.setDisplayName("§e§lBIGORNA");
		cdt.setItemMeta(cdt2);

		final ItemStack cbt1 = new ItemStack(Material.REDSTONE_LAMP_OFF);
		final ItemMeta cbt2 = cbt1.getItemMeta();
		cbt2.setDisplayName("§e§lLANTERNA");
		cbt1.setItemMeta(cbt2);

		final ItemStack rt = new ItemStack(Material.REDSTONE);
		final ItemMeta rt2 = rt.getItemMeta();
		rt2.setDisplayName("§e§lRETIRAR");

		rt.setItemMeta(rt2);
		inv.setItem(28, ct);
		inv.setItem(29, ft);
		inv.setItem(30, vt);
		inv.setItem(31, bt);
		inv.setItem(32, tt);
		inv.setItem(33, st);
		inv.setItem(34, dt);
		inv.setItem(37, cdt);
		inv.setItem(38, cbt1);
		inv.setItem(13, rt);
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

	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	void clicou(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (p.getOpenInventory().getTitle().equalsIgnoreCase("§7» §e§lCABEÇAS")) {

			if (e.getCurrentItem().getType() == Material.WORKBENCH) {
				p.getInventory().setHelmet(new ItemStack(Material.WORKBENCH));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lCRAFTING TABLE");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_LAMP_OFF) {
				p.getInventory().setHelmet(new ItemStack(Material.REDSTONE_LAMP_OFF));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lLAMPADA");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.FURNACE) {
				p.getInventory().setHelmet(new ItemStack(Material.FURNACE));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lFORNALHA");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				p.closeInventory();
				MenuOutros.guiKits(p);
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE) {
				if (!MenuCabeças.comchapeu.contains(p.getName())) {
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê Não Está Com Uma Cabeça Personalizada");
				} else {
					p.getInventory().setHelmet(new ItemStack(Material.AIR));
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lNENHUMA");
					MenuCabeças.comchapeu.remove(p.getName());
				}
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.GLASS) {
				p.getInventory().setHelmet(new ItemStack(Material.GLASS));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lVIDRO");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				p.getInventory().setHelmet(new ItemStack(Material.ANVIL));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lBIGORNA");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.TNT) {
				p.getInventory().setHelmet(new ItemStack(Material.TNT));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lTNT");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
				p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_BLOCK));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lDIAMANTE");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.THIN_GLASS) {
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.BOOKSHELF) {
				p.getInventory().setHelmet(new ItemStack(Material.BOOKSHELF));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lESTANTE");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.MOB_SPAWNER) {
				p.getInventory().setHelmet(new ItemStack(Material.MOB_SPAWNER));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §aCabeça Alterada Para: §e§lSPAWNER");
				MenuCabeças.comchapeu.remove(p);
				MenuCabeças.comchapeu.add(p.getName());
				p.closeInventory();
			}
		}
	}
}
