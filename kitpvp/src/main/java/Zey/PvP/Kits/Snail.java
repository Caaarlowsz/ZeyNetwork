package Zey.PvP.Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Snail extends Kit implements Listener {

	public Snail() {
		super("Snail");
	}

	@EventHandler
	public void onSnail(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		final Player d = (Player) e.getDamager();
		if (KitPvPAPI.getKit(d).equals(Kits.SNAIL)) {
			return;
		}
		if (Math.random() > 0.4 && Math.random() > 0.1) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 0));
		}
	}
}
