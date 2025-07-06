package Zey.PvP.Kits;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Zey.PvP.Essencial.Cooldown;
import Zey.PvP.Essencial.KitUtil;
import Zey.PvP.Eventos.Habilidade;
import Zey.PvP.Main.Main;

public class Thor implements Listener {
	@EventHandler
	public void ThorKit(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Thor")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.GOLD_AXE) {
			if (Cooldown.add(p)) {
				KitUtil.MensagemCooldown(p);
				return;
			}
			Cooldown.add(p, 5);
			@SuppressWarnings("deprecation")
			final Location loc = p.getTargetBlock((HashSet<Byte>) null, 30).getLocation();
			p.getWorld().strikeLightning(loc);
			e.setCancelled(true);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					KitUtil.ccooldown(p);
				}
			}, 100L);
		}
	}
}
