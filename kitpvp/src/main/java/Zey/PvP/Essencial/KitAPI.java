package Zey.PvP.Essencial;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import tk.zeynetwork.kitpvp.Warps;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class KitAPI {

	public static ArrayList<String> ForceField1 = new ArrayList<>();

	public static void sopa(final Player p) {
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta ksopa = sopa.getItemMeta();
		ksopa.setDisplayName("§e§lSOPA");
		sopa.setItemMeta(ksopa);
		for (int i = 0; i < 77; i++)
			p.getInventory().addItem(new ItemStack[] { sopa });
	}

	public static void recraft(final Player p) {
		final ItemStack sopas = new ItemStack(Material.BOWL, 64);
		final ItemMeta ksopas = sopas.getItemMeta();
		sopas.setItemMeta(ksopas);
		final ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
		final ItemMeta kcogur = cogur.getItemMeta();
		cogur.setItemMeta(kcogur);
		final ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
		final ItemMeta kcogum = cogum.getItemMeta();
		cogum.setItemMeta(kcogum);

		p.getInventory().setItem(13, sopas);
		p.getInventory().setItem(14, cogur);
		p.getInventory().setItem(15, cogum);
		final ItemStack espada1 = new ItemStack(Material.COMPASS);
		final ItemMeta kespada1 = espada1.getItemMeta();
		kespada1.setDisplayName("§e§lB§SSOLA");
		espada1.setItemMeta(kespada1);
		p.getInventory().setItem(8, espada1);
	}

	public static void swordkitpvp(final Player p) {
		final ItemStack item = new ItemStack(Material.STONE_SWORD);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		itemmeta.setDisplayName("§e§lESPADA");
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(0, item);

		ItemStack Peito = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta kPeito = (LeatherArmorMeta) Peito.getItemMeta();
		kPeito.setColor(Color.RED);
		Peito.setItemMeta(kPeito);

		p.getInventory().setChestplate((ItemStack) Peito);
		p.setAllowFlight(false);
		p.setFlying(false);

		KitPvPAPI.setWarp(p, Warps.ARENA);
	}

	public static void sword(final Player p) {
		final ItemStack espada = new ItemStack(Material.STONE_SWORD);
		final ItemMeta kespada = espada.getItemMeta();
		kespada.setDisplayName("§e§lESPADA");
		espada.setItemMeta(kespada);

		ItemStack Peito = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta kPeito = (LeatherArmorMeta) Peito.getItemMeta();
		kPeito.setColor(Color.RED);
		Peito.setItemMeta(kPeito);

		p.getInventory().setItem(0, espada);
		p.getInventory().setBoots((ItemStack) null);
		p.getInventory().setChestplate((ItemStack) Peito);
		p.getInventory().setLeggings((ItemStack) null);
		p.getInventory().setHelmet((ItemStack) null);
		p.setAllowFlight(false);
		p.setFlying(false);

		KitPvPAPI.setWarp(p, Warps.ARENA);
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
}
