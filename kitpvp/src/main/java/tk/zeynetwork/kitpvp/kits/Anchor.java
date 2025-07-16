package tk.zeynetwork.kitpvp.kits;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public final class Anchor extends Kit implements Listener {

	public Anchor() {
		super("Anchor");
	}

	@EventHandler
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;
		if (!(event.getDamager() instanceof Player))
			return;

		Player player = (Player) event.getEntity();
		if (KitPvPAPI.getKit(player).equals(Kits.ANCHOR)) {
			this.applyAnchorEffect(player, player);
			return;
		}

		Player damager = (Player) event.getDamager();
		if (KitPvPAPI.getKit(damager).equals(Kits.ANCHOR)) {
			this.applyAnchorEffect(damager, player);
			return;
		}
	}

	private void applyAnchorEffect(Player damager, Player target) {
		damager.playSound(damager.getLocation(), Sound.ANVIL_BREAK, 4, 4);
		target.setVelocity(new Vector());
		Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> target.setVelocity(new Vector()), 1L);
	}
}