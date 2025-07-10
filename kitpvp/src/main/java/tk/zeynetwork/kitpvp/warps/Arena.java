package tk.zeynetwork.kitpvp.warps;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import tk.zeynetwork.kitpvp.api.Warp;
import tk.zeynetwork.utils.ItemUtils;

public final class Arena extends Warp {

	public Arena() {
		super("Arena");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);

		PlayerInventory inv = player.getInventory();
		inv.setItem(8, ItemUtils.item(Material.COMPASS, "§e§lBÚSSOLA"));
		inv.setItem(13, ItemUtils.item(Material.BOWL, 64));
		inv.setItem(14, ItemUtils.item(Material.RED_MUSHROOM, 64));
		inv.setItem(15, ItemUtils.item(Material.BROWN_MUSHROOM, 64));

		for (int i = 0; i < 31; i++)
			inv.addItem(ItemUtils.item(Material.MUSHROOM_SOUP, "§e§lSOPA"));
	}
}