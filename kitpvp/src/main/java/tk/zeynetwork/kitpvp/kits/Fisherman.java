package tk.zeynetwork.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;

public final class Fisherman extends Kit implements Listener {

	public Fisherman() {
		super("Fisherman");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(1, ItemUtils.item(Material.FISHING_ROD, "§e§lFISHERMAN"));
	}

	@EventHandler
	private void onPlayerFish(PlayerFishEvent event) {
		if (!(event.getCaught() instanceof Player))
			return;
		Player player = event.getPlayer(), caught = (Player) event.getCaught();
		if (caught == null)
			return;
		if (caught == player)
			return;

		if (KitPvPAPI.getKit(player).equals(Kits.FISHERMAN))
			this.applyFishermanEffect(player, caught);
	}

	private void applyFishermanEffect(Player player, Player target) {
		target.teleport(player.getLocation());
	}
}