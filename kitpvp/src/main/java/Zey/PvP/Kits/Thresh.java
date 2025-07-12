package Zey.PvP.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Thresh extends Kit implements Listener {
	public static HashMap<String, Long> cooldown = new HashMap<>();
	public static HashMap<String, Snowball> tiros = new HashMap<>();

	public Thresh() {
		super("Thresh");
	}

	@EventHandler
	public void disparar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.LEVER && KitPvPAPI.getKit(p).equals(Kits.THRESH)) {
			if (!Thresh.cooldown.containsKey(p.getName())
					|| Thresh.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				final Snowball tiro = (Snowball) p.launchProjectile((Class<? extends Projectile>) Snowball.class);
				final Vector vec = p.getLocation().getDirection();
				tiro.setVelocity(new Vector(vec.getX() * 1.0 * 3.5, vec.getY() * 1.0 * 4.0, vec.getZ() * 1.0 * 3.5));
				Thresh.tiros.put(p.getName(), tiro);
				Thresh.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
				p.playSound(p.getLocation(), Sound.GLASS, 1.0f, 1.0f);
				p.sendMessage(String.valueOf(Main.NAME) + " §7» §aVocê usou seu Thresh.");
				return;
			}
			p.sendMessage(String.valueOf(Main.NAME) + " §7» §cAguarde o cooldown terminar.");
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDamagerByEntity(final EntityDamageByEntityEvent e) {
		final Entity ent = e.getEntity();
		final Entity damager = e.getDamager();
		if (ent instanceof Player) {
			final Player hit = (Player) ent;
			if (damager instanceof Snowball) {
				final Snowball snowball = (Snowball) damager;
				if (snowball.getShooter() instanceof Player) {
					final Player shooter = (Player) snowball.getShooter();
					if (!KitPvPAPI.getKit(shooter).equals(Kits.THRESH)) {
						return;
					}
					final Location ploc = shooter.getLocation();
					hit.teleport(ploc);
					hit.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
					hit.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
					hit.sendMessage(String.valueOf(Main.NAME) + " §7» §cVocê foi pego por um Thresh.");
				}
			}
		}
	}
}
