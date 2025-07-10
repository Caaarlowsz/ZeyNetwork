package tk.zeynetwork.utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
}