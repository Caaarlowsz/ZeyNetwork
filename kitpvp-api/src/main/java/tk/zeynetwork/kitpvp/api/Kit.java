package tk.zeynetwork.kitpvp.api;

import org.bukkit.entity.Player;

public class Kit {

	private final String name;

	public Kit(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void giveItems(Player player) {
	}
}