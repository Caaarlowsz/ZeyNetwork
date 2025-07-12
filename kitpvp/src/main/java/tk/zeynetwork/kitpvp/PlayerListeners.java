package tk.zeynetwork.kitpvp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import tk.zeynetwork.kitpvp.api.KitPvP;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.TitleAPI;

public final class PlayerListeners implements Listener {

	@EventHandler
	private void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		TitleAPI.reset(player);

		KitPvP api = KitPvPAPI.getInstance();
		api.removeKit(player);
		api.setWarp(event.getPlayer(), Warps.SPAWN);
	}

	@EventHandler
	private void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		KitPvP api = KitPvPAPI.getInstance();
		api.removeKit(player);
		api.setWarp(player, Warps.SPAWN);
	}

	@EventHandler
	private void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		KitPvP api = KitPvPAPI.getInstance();
		api.removeWarp(player);
		api.removeKit(player);
	}
}