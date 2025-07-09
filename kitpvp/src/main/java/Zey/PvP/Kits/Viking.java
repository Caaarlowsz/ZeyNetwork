package Zey.PvP.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import Zey.PvP.Eventos.Habilidade;
import tk.zeynetwork.kitpvp.api.Kit;

public class Viking extends Kit implements Listener {

	public Viking() {
		super("Viking");
	}

	@EventHandler
	public void aoviking(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Viking") && e.getEntity() instanceof Player
					&& p.getItemInHand().getType() == Material.STONE_AXE) {
				e.setDamage(e.getDamage() * 1.66);
			}
		}
	}
}
