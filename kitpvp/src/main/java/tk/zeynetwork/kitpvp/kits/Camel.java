package tk.zeynetwork.kitpvp.kits;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public final class Camel extends Kit implements Listener {

	public Camel() {
		super("Camel");
	}

	@EventHandler
	private void onPlayerMove(PlayerMoveEvent event) {
		Location from = event.getFrom(), to = event.getTo();
		if (from.getBlockX() == to.getBlockX()
				&& from.getBlockY() == to.getBlockY()
				&& from.getBlockZ() == to.getBlockZ())
			return;
		if (!to.getBlock().getRelative(BlockFace.DOWN).getType().name().contains("SAND"))
			return;

		Player player = event.getPlayer();
		if (KitPvPAPI.getKit(player).equals(Kits.CAMEL))
			this.applyCamelEffect(player);
	}

	private void applyCamelEffect(Player player) {
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0, true));
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0, true));
	}
}