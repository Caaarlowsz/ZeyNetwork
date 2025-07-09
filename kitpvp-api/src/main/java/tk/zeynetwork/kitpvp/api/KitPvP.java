package tk.zeynetwork.kitpvp.api;

import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public interface KitPvP {

	String getApiVersion();

	Plugin getPlugin();
	
	Set<Warp> getWarps();
	
	Warp getWarp(String name);
	
	void addWarp(Warp warp);
	
	void removeWarp(Warp warp);
	
	boolean hasWarp(Player player);

	Warp getWarp(Player player);

	void setWarp(Player player, Warp warp);

	void removeWarp(Player player);
}