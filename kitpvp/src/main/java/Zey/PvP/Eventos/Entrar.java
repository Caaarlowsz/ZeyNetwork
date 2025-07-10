package Zey.PvP.Eventos;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Zey.PvP.Commands.BuildCommand;
import Zey.PvP.Main.Main;
import Zey.PvP.Utils.Proteção;
import tk.zeynetwork.kitpvp.Warps;
import tk.zeynetwork.kitpvp.api.KitPvP;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;
import tk.zeynetwork.utils.TitleAPI;

public class Entrar implements Listener {
	@EventHandler
	public void Join(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();

		TitleAPI.sendTitle(p, Main.PREFIX, "§fTreine para se tornar o melhor!");

		KitPvP api = KitPvPAPI.getInstance();
		api.removeKit(p);
		BuildCommand.embuild.remove(p);
		p.setGameMode(GameMode.SURVIVAL);
		api.setWarp(p, Warps.SPAWN);

		Proteção.setImortal(p, true);
		Proteção.isImortal(p);

		p.sendMessage("§a  ");
		p.sendMessage("§a  ");
		p.sendMessage("§a  ");
		p.sendMessage("§c" + Main.PREFIX + " §7» §fTreine para se tornar o melhor!");
		p.sendMessage("§a  ");

		p.teleport(p.getWorld().getSpawnLocation());
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0f, 0.0f);
		p.getInventory().setHelmet((ItemStack) null);
		p.getInventory().setChestplate((ItemStack) null);
		p.getInventory().setLeggings((ItemStack) null);
		p.getInventory().setBoots((ItemStack) null);
		e.setJoinMessage((String) null);
		p.getInventory().clear();

		final ItemStack vidrohot = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta vidrohotx = vidrohot.getItemMeta();
		vidrohotx.setDisplayName("§6§lZey§f§lPvP");
		vidrohot.setItemMeta(vidrohotx);

		p.getInventory().setItem(0, vidrohot);
		p.getInventory().setItem(1, vidrohot);
		p.getInventory().setItem(2, ItemUtils.item(Material.PAPER, "§e§lWARPS"));
		p.getInventory().setItem(3, vidrohot);
		p.getInventory().setItem(4, ItemUtils.item(Material.ENDER_CHEST, "§e§lKITS"));
		p.getInventory().setItem(5, vidrohot);
		p.getInventory().setItem(6, ItemUtils.item(Material.BOOK, "§e§lMENU GERAL"));
		p.getInventory().setItem(7, vidrohot);
		p.getInventory().setItem(8, vidrohot);

		p.performCommand("tag normal");
	}

	@EventHandler
	public void Morte(final PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		p.getInventory().setHelmet((ItemStack) null);
		p.getInventory().setChestplate((ItemStack) null);
		p.getInventory().setLeggings((ItemStack) null);
		p.getInventory().setBoots((ItemStack) null);
		p.getInventory().clear();

		KitPvP api = KitPvPAPI.getInstance();
		api.removeKit(p);
		BuildCommand.embuild.remove(p);
		p.setGameMode(GameMode.SURVIVAL);
		api.setWarp(p, Warps.SPAWN);

		Proteção.setImortal(p, true);
		Proteção.isImortal(p);

		final ItemStack vidrohot = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta vidrohotx = vidrohot.getItemMeta();
		vidrohotx.setDisplayName("§6§lZey§f§lPvP");
		vidrohot.setItemMeta(vidrohotx);

		p.getInventory().setItem(0, vidrohot);
		p.getInventory().setItem(1, vidrohot);
		p.getInventory().setItem(2, ItemUtils.item(Material.PAPER, "§e§lWARPS"));
		p.getInventory().setItem(3, vidrohot);
		p.getInventory().setItem(4, ItemUtils.item(Material.ENDER_CHEST, "§e§lKITS"));
		p.getInventory().setItem(5, vidrohot);
		p.getInventory().setItem(6, ItemUtils.item(Material.BOOK, "§e§lMENU GERAL"));
		p.getInventory().setItem(7, vidrohot);
		p.getInventory().setItem(8, vidrohot);

		TitleAPI.sendTitle(p, Main.PREFIX, "§7Você morreu.");
	}

	public static void setitem(final Player p, final Material mat, final String nome, final int lugar,
			final Enchantment enchant, final int level, final boolean trueorfalse) {
		final ItemStack item = new ItemStack(mat);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		itemmeta.addEnchant(enchant, level, trueorfalse);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	@EventHandler
	public void onSair(final PlayerQuitEvent e) {
		@SuppressWarnings("unused")
		final Player p = e.getPlayer();
		e.setQuitMessage((String) null);
	}
}
