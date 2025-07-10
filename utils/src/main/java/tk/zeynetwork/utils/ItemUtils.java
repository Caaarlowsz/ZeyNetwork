package tk.zeynetwork.utils;

import java.util.Arrays;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemUtils {

	public static ItemStack item(Material type) {
		return item(type, 1);
	}

	public static ItemStack item(Material type, int amount) {
		return item(type, amount, 0);
	}

	public static ItemStack item(Material type, int amount, int durability) {
		return new ItemStack(type, amount, (short) durability);
	}

	public static ItemStack item(Material type, String display, String... lore) {
		return item(type, 1, display, lore);
	}

	public static ItemStack item(Material type, int amount, String display, String... lore) {
		return item(type, amount, 0, display, lore);
	}

	public static ItemStack item(Material type, int amount, int durability, String display, String... lore) {
		ItemStack item = item(type, amount, durability);
		ItemMeta mItem = item.getItemMeta();
		mItem.setDisplayName(display);
		mItem.setLore(Arrays.asList(lore));
		item.setItemMeta(mItem);
		return item;
	}

	public static ItemStack leatherArmor(Material type, Color color) {
		return leatherArmor(type, color, 1);
	}

	public static ItemStack leatherArmor(Material type, Color color, int amount) {
		return leatherArmor(type, color, amount, 0);
	}

	public static ItemStack leatherArmor(Material type, Color color, int amount, int durability) {
		return colorArmor(item(type, amount, durability), color);
	}

	public static ItemStack leatherArmor(Material type, Color color, String display, String... lore) {
		return leatherArmor(type, color, 1, display, lore);
	}

	public static ItemStack leatherArmor(Material type, Color color, int amount, String display, String... lore) {
		return leatherArmor(type, color, amount, 0, display, lore);
	}

	public static ItemStack leatherArmor(Material type, Color color, int amount, int durability, String display,
			String... lore) {
		return colorArmor(item(type, amount, durability, display, lore), color);
	}

	private static ItemStack colorArmor(ItemStack item, Color color) {
		LeatherArmorMeta mItem = (LeatherArmorMeta) item.getItemMeta();
		mItem.setColor(color);
		item.setItemMeta(mItem);
		return item;
	}
}