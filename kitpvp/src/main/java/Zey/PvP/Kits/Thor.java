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
import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Thor extends Kit implements Listener {

	public Thor() {
		super("Thor");
	}

	@EventHandler
	public void ThorKit(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitPvPAPI.getKit(p).equals(Kits.THOR)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.GOLD_AXE) {
			if (Cooldown.add(p)) {
				p.sendMessage(String.valueOf(Main.NAME) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
				return;
			}
			Cooldown.add(p, 5);
			final Location loc = p.getTargetBlock((HashSet<Byte>) null, 30).getLocation();
			p.getWorld().strikeLightning(loc);
			e.setCancelled(true);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §aSeu cooldown acabou.");
				}
			}, 100L);
		}
	}
}