package tk.zeynetwork.kitpvp.kits;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;

public final class Kangaroo extends Kit implements Listener {

	private HashMap<Player, Byte> boostMap = new HashMap<>();

	public Kangaroo() {
		super("Kangaroo");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(1, ItemUtils.item(Material.FIREWORK, "§e§lKANGAROO"));
	}

	@EventHandler
	private void onPlayerInteract(PlayerInteractEvent event) {
		if (!event.hasItem()) return;

		Player player = event.getPlayer();
		if (KitPvPAPI.getKit(player).equals(Kits.KANGAROO) && event.getItem().getType().equals(Material.FIREWORK)) {
			event.setCancelled(true);

			byte b = this.boostMap.getOrDefault(player, (byte) 0);
			if (b < 1) {
				this.applyKangarooEffect(player);
				this.boostMap.put(player, ++b);
			}
			return;
		}
	}

	@EventHandler
	private void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (!this.boostMap.containsKey(player)) return;

		Block block = player.getLocation().getBlock();
		if (!block.getType().equals(Material.AIR) || !block.getRelative(BlockFace.DOWN).getType().equals(Material.AIR)) {
			this.boostMap.remove(player);
			return;
		}
	}

	@EventHandler
	private void onEntityDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) return;
		if (!event.getCause().equals(DamageCause.FALL)) return;

		Player player = (Player) event.getEntity();
		if (!KitPvPAPI.getKit(player).equals(Kits.KANGAROO)) return;

		if (event.getDamage() >= 12.0) {
			event.setDamage(12.0);
			return;
		}
	}

	private void applyKangarooEffect(Player player) {
		Vector vector = player.getEyeLocation().getDirection();
		if (!player.isSneaking()) {
			vector.multiply(0.6f);
			vector.setY(1.0f);
		} else {
			vector.multiply(1.35f);
			vector.setY(0.66);
		}
		player.setVelocity(vector);
		player.setFallDistance(-3f);
	}
}