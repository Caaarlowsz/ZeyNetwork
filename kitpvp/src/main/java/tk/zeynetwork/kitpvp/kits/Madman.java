package tk.zeynetwork.kitpvp.kits;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public final class Madman extends Kit implements Listener {

	public Madman() {
		super("Madman");
	}

	@EventHandler
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (new Random().nextInt(100) > 40) return;
		if (!(event.getEntity() instanceof Player)) return;
		if (!(event.getDamager() instanceof Player)) return;

		Player player = (Player) event.getEntity(), damager = (Player) event.getDamager();
		if (KitPvPAPI.getKit(damager).equals(Kits.MADMAN) && damager.getItemInHand().getType().equals(Material.STONE_SWORD)) {
			this.applyMadmanEffect(player);
			return;
		}
	}

	private void applyMadmanEffect(Player target) {
		target.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 3));
		target.sendMessage(Main.PREFIX + "§cVocê foi afetado, por um madman.");
	}
}