package tk.zeynetwork.kitpvp.api;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class KitPvPAPI {

	private static KitPvP kitpvp;

	public static KitPvP getInstance() {
		if (kitpvp == null)
			throw new IllegalStateException(
					"KitPvPAPI ainda não foi instanciada! Construa a instância no plugin primeiro.");
		return kitpvp;
	}

	public static void setInstance(KitPvP instance) {
		if (kitpvp != null)
			throw new IllegalStateException("KitPvPAPI já foi instanciada! Use KitPvPAPI.getInstance() para obtê-la.");
		kitpvp = instance;
		Bukkit.getLogger().info("KitPvPAPI instanciada com sucesso! Versão: " + getApiVersion());
	}

	public static String getApiVersion() {
		return kitpvp.getApiVersion();
	}

	public static Set<Warp> getWarps() {
		return kitpvp.getWarps();
	}

	public static Warp getWarp(String name) {
		return kitpvp.getWarp(name);
	}

	public static void addWarp(Warp warp) {
		kitpvp.addWarp(warp);
	}

	public static void removeWarp(Warp warp) {
		kitpvp.removeWarp(warp);
	}

	public static boolean hasWarp(Player player) {
		return kitpvp.hasWarp(player);
	}

	public static Warp getWarp(Player player) {
		return kitpvp.getWarp(player);
	}

	public static void setWarp(Player player, Warp warp) {
		kitpvp.setWarp(player, warp);
	}

	public static void removeWarp(Player player) {
		kitpvp.removeWarp(player);
	}

	public static Set<Kit> getKits() {
		return kitpvp.getKits();
	}

	public static Kit getKit(String name) {
		return kitpvp.getKit(name);
	}

	public static void addKit(Kit kit) {
		kitpvp.addKit(kit);
	}

	public static void removeKit(Kit kit) {
		kitpvp.removeKit(kit);
	}

	public static boolean hasKit(Player player) {
		return kitpvp.hasKit(player);
	}

	public static Kit getKit(Player player) {
		return kitpvp.getKit(player);
	}

	public static void setKit(Player player, Kit kit) {
		kitpvp.setKit(player, kit);
	}

	public static void removeKit(Player player) {
		kitpvp.removeKit(player);
	}
}