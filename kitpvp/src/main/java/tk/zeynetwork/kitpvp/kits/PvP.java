package tk.zeynetwork.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.utils.ItemUtils;

public final class PvP extends Kit {

	public PvP() {
		super("PvP");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		ItemStack sword = ItemUtils.item(Material.STONE_SWORD, "§e§lESPADA");
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		player.getInventory().setItem(0, sword);
	}
}