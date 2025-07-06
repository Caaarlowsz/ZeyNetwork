
package Zey.PvP.APIs;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class WarpAPI {

	private static HashMap<Player, String> Warp = new HashMap<>();

	public static String getWarp(Player p) {

		if (Warp.containsKey(p)) {
			return Warp.get(p);
		} else {
			return "Spawn";
		}
	}

	public static void setWarp(Player p, String warp) {
		Warp.put(p, warp);
	}
}
