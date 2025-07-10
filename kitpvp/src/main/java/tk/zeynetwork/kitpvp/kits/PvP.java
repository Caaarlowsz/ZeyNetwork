package tk.zeynetwork.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.utils.ItemUtils;

public final class PvP extends Kit {

	public PvP() {
		super("PvP");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(0,
				ItemUtils.enchantedItem(Material.STONE_SWORD, Enchantment.DAMAGE_ALL, 1, "§e§lESPADA"));
	}
}