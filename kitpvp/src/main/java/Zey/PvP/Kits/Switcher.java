package Zey.PvP.Kits;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Switcher extends Kit implements Listener {

	public Switcher() {
		super("Switcher");
	}

	@EventHandler
	public void snowball(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Snowball && e.getEntity() instanceof Player) {
			final Snowball s = (Snowball) e.getDamager();
			if (s.getShooter() instanceof Player) {
				final Player shooter = (Player) s.getShooter();
				if (KitPvPAPI.getKit(shooter).equals(Kits.SWITCHER)) {
					final Location shooterLoc = shooter.getLocation();
					shooter.teleport(e.getEntity().getLocation());
					e.getEntity().teleport(shooterLoc);
					shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
					shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
					shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
				}
			}
		}
	}

	@EventHandler
	public void aomatar(final PlayerDeathEvent e) {
		final Player matou = e.getEntity().getKiller();
		if (e.getEntity().getKiller() instanceof Player && KitPvPAPI.getKit(matou).equals(Kits.SWITCHER)) {
			final ItemStack item = new ItemStack(Material.SNOW_BALL);
			final ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName("§e§lSWITCHER");
			item.setItemMeta(itemm);
			matou.getInventory().addItem(new ItemStack[] { item });
			matou.updateInventory();
		}
	}
}