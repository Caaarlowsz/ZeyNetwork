package tk.zeynetwork.kitpvp.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public final class AntiTower extends Kit implements Listener {

	public AntiTower() {
		super("AntiTower");
	}

	@EventHandler
	private void onEntityDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;
		if (!event.getCause().equals(DamageCause.FALL))
			return;

		Player player = (Player) event.getEntity();
		if (KitPvPAPI.getKit(player).equals(Kits.ANTITOWER))
			this.applyAntiTowerEffect(event);
	}

	private void applyAntiTowerEffect(EntityDamageEvent damageFallEvent) {
		damageFallEvent.setDamage(6D);
	}
}