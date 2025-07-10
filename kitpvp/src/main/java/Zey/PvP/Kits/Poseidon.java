package Zey.PvP.Kits;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import Zey.PvP.Essencial.KitUtil;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Poseidon extends Kit implements Listener {

	public Poseidon() {
		super("Poseidon");
	}

	@EventHandler
	public void aoPoseidon(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		final Block b = p.getLocation().getBlock();
		if (KitPvPAPI.getKit(p).equals(Kits.POSEIDON)
				&& (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER)) {
			KitUtil.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
			KitUtil.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 10, 1);
			KitUtil.darEfeito(p, PotionEffectType.SPEED, 8, 0);
		}
	}
}