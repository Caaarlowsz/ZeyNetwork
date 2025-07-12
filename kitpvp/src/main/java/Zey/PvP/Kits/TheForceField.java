package Zey.PvP.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Zey.PvP.Essencial.KitAPI;
import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;

public class TheForceField extends Kit implements Listener {
	public static List<Player> cooldownm = new ArrayList<>();

	public TheForceField() {
		super("ForceField");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(1, ItemUtils.item(Material.NETHER_FENCE, "§e§lFORCEFIELD"));
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.NETHER_FENCE
				&& KitPvPAPI.getKit(p).equals(Kits.FORCEFIELD)) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (TheForceField.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(Main.NAME) + " §7» §cAguarde o cooldown terminar.");
				return;
			}
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 0.5f, 0.5f);
			TheForceField.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.ForceField1.add(p.getName());
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §7Você usou sua habilidade de ForceField.");
				}
			}, 0L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.ForceField1.remove(p.getName());
				}
			}, 50L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					TheForceField.cooldownm.remove(p);
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §aSeu cooldown acabou.");
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 0.5f, 0.5f);
				}
			}, 300L);
		}
	}

	@EventHandler
	public void fraqueza(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (KitAPI.ForceField1.contains(p.getName())) {
			for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (pertos instanceof Player) {
					if (KitPvPAPI.getKit(p).equals(Kits.FORCEFIELD)) {
						((Player) pertos).damage(3.0);
					}
					pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(),
							(Runnable) new Runnable() {
								@Override
								public void run() {
								}
							}, 10L);
				}
			}
		}
	}
}
