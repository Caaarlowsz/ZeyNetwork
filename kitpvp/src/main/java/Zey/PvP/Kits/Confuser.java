package Zey.PvP.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Zey.PvP.Essencial.Cooldown;
import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Confuser extends Kit implements Listener {

	public Confuser() {
		super("Confuser");
	}

	@EventHandler
	public void onConfusao(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitPvPAPI.getKit(p).equals(Kits.CONFUSER)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.COAL) {
			e.setCancelled(true);
			if (Cooldown.add(p)) {
				p.sendMessage(String.valueOf(Main.NAME) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
				return;
			}
			Cooldown.add(p, 40);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
			for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
				((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
				((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
			}
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §aSeu cooldown acabou.");
				}
			}, 800L);
		}
	}
}