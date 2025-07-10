package tk.zeynetwork.kitpvp.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class Warp {

	private final String name;

	public Warp(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void giveItems(Player player) {
		player.setAllowFlight(false);
		player.setFlying(false);

		PlayerInventory inv = player.getInventory();
		inv.setArmorContents(null);
		inv.clear();
	}
}