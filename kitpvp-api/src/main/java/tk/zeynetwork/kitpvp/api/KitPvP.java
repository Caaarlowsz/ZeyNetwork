package tk.zeynetwork.kitpvp.api;

import java.util.Set;

import org.bukkit.entity.Player;

public interface KitPvP {

	String getApiVersion();

	Set<Warp> getWarps();

	Warp getWarp(String name);

	void addWarp(Warp warp);

	void removeWarp(Warp warp);

	boolean hasWarp(Player player);

	Warp getWarp(Player player);

	void setWarp(Player player, Warp warp);

	void removeWarp(Player player);

	Set<Kit> getKits();

	Kit getKit(String name);

	void addKit(Kit kit);

	void removeKit(Kit kit);

	boolean hasKit(Player player);

	Kit getKit(Player player);

	void setKit(Player player, Kit kit);

	void removeKit(Player player);
}