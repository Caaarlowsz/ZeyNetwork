package tk.zeynetwork.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.utils.ItemUtils;

public final class Archer extends Kit {

	public Archer() {
		super("Archer");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(1, ItemUtils.enchantedItem(Material.BOW, Enchantment.ARROW_INFINITE, 1, "§e§lARCHER"));
		player.getInventory().setItem(2, ItemUtils.item(Material.ARROW, "§cFLECHA"));
	}
}