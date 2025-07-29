package tk.zeynetwork.kitpvp.kits;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public final class Magma extends Kit implements Listener {

	public Magma() {
		super("Magma");
	}

	@EventHandler
	private void onEntityDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) return;
		if (!event.getCause().name().contains("LAVA") && !event.getCause().name().contains("FIRE")) return;

		Player player = (Player) event.getEntity();
		if (KitPvPAPI.getKit(player).equals(Kits.MAGMA)) {
			event.setCancelled(true);
			return;
		}
	}

	@EventHandler
	private void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (KitPvPAPI.getKit(player).equals(Kits.MAGMA) && player.getLocation().getBlock().getType().name().contains("WATER"))
			player.damage(1.0);
	}

	@EventHandler
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (new Random().nextInt(100) > 33) return;
		if (!(event.getEntity() instanceof Player)) return;
		if (!(event.getDamager() instanceof Player)) return;

		Player player = (Player) event.getEntity(), damager = (Player) event.getDamager();
		if (KitPvPAPI.getKit(damager).equals(Kits.MAGMA) && damager.getInventory().getItemInHand() != null) {
			this.applyMagmaEffect(player);
			return;
		}
	}

	private void applyMagmaEffect(Player target) {
		target.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10, 1));
		target.setFireTicks(50);
	}
}