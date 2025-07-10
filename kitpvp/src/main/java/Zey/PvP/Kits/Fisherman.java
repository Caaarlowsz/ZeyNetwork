package Zey.PvP.Kits;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Fisherman extends Kit implements Listener {

	public Fisherman() {
		super("Fisherman");
	}

	@EventHandler
	public void onPlayerFish(final PlayerFishEvent event) {
		final Entity caught = event.getCaught();
		final Block block = event.getHook().getLocation().getBlock();
		if (caught != null && caught != block && KitPvPAPI.getKit(event.getPlayer()).equals(Kits.FISHERMAN)) {
			caught.teleport(event.getPlayer().getLocation());
		}
	}
}
