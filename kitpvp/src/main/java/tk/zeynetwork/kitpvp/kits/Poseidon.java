package tk.zeynetwork.kitpvp.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public final class Poseidon extends Kit implements Listener {

	public Poseidon() {
		super("Poseidon");
	}

	@EventHandler
	private void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (!player.getLocation().getBlock().getType().name().contains("WATER")) return;

		if (KitPvPAPI.getKit(player).equals(Kits.POSEIDON)) {
			this.applyPoseidonEffect(player);
			return;
		}
	}

	private void applyPoseidonEffect(Player player) {
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1));
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 1));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 160, 1));
	}
}