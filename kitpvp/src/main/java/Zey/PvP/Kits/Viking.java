package Zey.PvP.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;

public class Viking extends Kit implements Listener {

	public Viking() {
		super("Viking");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(0, ItemUtils.item(Material.STONE_AXE, "§e§lVIKING"));
	}

	@EventHandler
	public void aoviking(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (KitPvPAPI.getKit(p).equals(Kits.VIKING) && e.getEntity() instanceof Player
					&& p.getItemInHand().getType() == Material.STONE_AXE) {
				e.setDamage(e.getDamage() * 1.66);
			}
		}
	}
}