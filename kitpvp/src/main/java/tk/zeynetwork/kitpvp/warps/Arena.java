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
		for (int i = 0; i < 31; i++)
			inv.addItem(ItemUtils.item(Material.MUSHROOM_SOUP, "§e§lSOPA"));
	}
}