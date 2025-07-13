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

import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.CooldownKit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;

public class Thor extends CooldownKit implements Listener {

	public Thor() {
		super("Thor");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(1, ItemUtils.item(Material.GOLD_AXE, "§e§lTHOR"));
	}

	@EventHandler
	public void ThorKit(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitPvPAPI.getKit(p).equals(Kits.THOR)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.GOLD_AXE) {
			if (this.hasCooldown(p)) {
				p.sendMessage(String.valueOf(Main.NAME) + " §7» §cAguarde " + this.getRemaingTime(p) + " segundos");
				return;
			}
			this.addCooldown(Main.getPlugin(), p, 5);
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