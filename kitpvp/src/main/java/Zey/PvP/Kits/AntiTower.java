package Zey.PvP.Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class AntiTower extends Kit implements Listener {

	public AntiTower() {
		super("AntiTower");
	}

	@EventHandler
	public void aogalinha(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			final Player p = (Player) e.getEntity();
			if (KitPvPAPI.getKit(p).equals(Kits.ANTITOWER)) {
				e.setDamage(6.0D);
			}
		}
	}
}