package Zey.PvP.Kits;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import Zey.PvP.Essencial.KitAPI;
import Zey.PvP.Main.Main;

public class Stomper implements Listener {
	public Stomper(final Main main) {
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerStomp(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (KitAPI.Stomper.contains(p.getName())) {
			for (final Entity ent : p.getNearbyEntities(8.0, 5.0, 8.0)) {
				if (ent instanceof Player) {
					final Player plr = (Player) ent;
					if (e.getDamage() <= 2.0) {
						e.setCancelled(true);
						return;
					}
					if (plr.isSneaking()) {
						plr.damage(20.0, (Entity) p);
					} else {
						plr.damage(e.getDamage(), (Entity) p);
					}
				}
			}
			e.setDamage(4.0);
		}
	}
}
