package Zey.PvP.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.CooldownKit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;

public class Rain extends CooldownKit implements Listener {

	public Rain() {
		super("Rain");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(1, ItemUtils.item(Material.ARROW, "§e§lRAIN"));
	}

	@EventHandler
	public void onCage(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = e.getPlayer();
		final Player t = (Player) e.getRightClicked();
		if (KitPvPAPI.getKit(p).equals(Kits.RAIN) && p.getItemInHand().getType() == Material.ARROW) {
			if (this.hasCooldown(p)) {
				p.sendMessage(String.valueOf(Main.NAME) + " §7» §cAguarde " + this.getRemaingTime(p) + " segundos");
				return;
			}
			this.addCooldown(Main.getPlugin(), p, 25);
			final Location loc = t.getLocation();
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.shootArrow();
					loc.setY(loc.getY() + 1.0);
					final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
					r.setVelocity(r.getVelocity().multiply(8));
				}
			}, 0L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.shootArrow();
					loc.setY(loc.getY() + 1.0);
					final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
					r.setVelocity(r.getVelocity().multiply(8));
				}
			}, 10L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.shootArrow();
					loc.setY(loc.getY() + 1.0);
					final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
					r.setVelocity(r.getVelocity().multiply(8));
				}
			}, 15L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.shootArrow();
					loc.setY(loc.getY() + 1.0);
					final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
					r.setVelocity(r.getVelocity().multiply(8));
				}
			}, 20L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.shootArrow();
					loc.setY(loc.getY() + 1.0);
					final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
					r.setVelocity(r.getVelocity().multiply(8));
				}
			}, 25L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.shootArrow();
					loc.setY(loc.getY() + 1.0);
					final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
					r.setVelocity(r.getVelocity().multiply(8));
				}
			}, 30L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.shootArrow();
					loc.setY(loc.getY() + 1.0);
					final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
					r.setVelocity(r.getVelocity().multiply(8));
				}
			}, 35L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §aSeu cooldown acabou.");
				}
			}, 500L);
		}
	}
}