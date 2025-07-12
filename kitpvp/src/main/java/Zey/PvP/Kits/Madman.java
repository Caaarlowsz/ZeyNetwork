package Zey.PvP.Kits;

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

public class Madman extends Kit implements Listener {

	public Madman() {
		super("Madman");
	}

	@EventHandler
	public void bater(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player t = (Player) e.getDamager();
			if (KitPvPAPI.getKit(t).equals(Kits.MADMAN) && (t.getItemInHand().getType() == Material.STONE_SWORD)) {
				if (new Random().nextInt(100) <= 40) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 10 * 20, 3));
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §cVocê foi afetado, por um madman.");
				}
			}
		}
	}
}