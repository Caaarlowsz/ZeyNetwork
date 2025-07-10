package Zey.PvP.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Resouper extends Kit implements Listener {

	public Resouper() {
		super("Resouper");
	}

	@EventHandler
	public void aomatar(final PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			final Player p = e.getEntity().getKiller();
			if (KitPvPAPI.getKit(p).equals(Kits.RESOUPER)) {
				for (int i = 0; i < p.getInventory().getSize(); ++i) {
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
					p.updateInventory();
				}
			}
		}
	}
}