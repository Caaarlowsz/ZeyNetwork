package Zey.PvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;

public class TimeLord extends Kit implements Listener {
	public static ArrayList<String> freeze = new ArrayList<>();
	public static ArrayList<String> freezing = new ArrayList<>();
	public ArrayList<String> frozenPlayers = new ArrayList<>();
	public static ArrayList<String> cooldownt = new ArrayList<>();

	public TimeLord() {
		super("TimeLord");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(1, ItemUtils.item(Material.WATCH, "§e§lTIMELORD"));
	}

	@EventHandler
	public void timelordkit(final PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& player.getItemInHand().getType() == Material.WATCH
				&& KitPvPAPI.getKit(player).equals(Kits.TIMELORD)) {
			if (TimeLord.cooldownt.contains(player.getName())) {
				player.sendMessage(String.valueOf(Main.NAME) + " §7» §cAguarde o cooldown terminar.");
			} else {
				for (final Entity frozen : player.getNearbyEntities(2.0, 3.0, 2.0)) {
					if (frozen != null && frozen instanceof Player) {
						TimeLord.freeze.add(((Player) frozen).getName());
						if (TimeLord.freezing.contains(player.getName())) {
							continue;
						}
						player.getWorld().playEffect(player.getLocation(), Effect.POTION_BREAK, 10);
						player.getWorld().playSound(player.getLocation(), Sound.WITHER_SHOOT, 10.0f, 1.0f);
						TimeLord.freezing.add(player.getName());
						TimeLord.cooldownt.add(player.getName());
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.getPlugin(),
								(Runnable) new Runnable() {
									@Override
									public void run() {
										TimeLord.freezing.remove(player.getName());
										TimeLord.cooldownt.remove(player.getName());
										player.sendMessage(String.valueOf(Main.NAME) + " §7» §aSeu cooldown terminou.");
									}
								}, 500L);
					}
				}
			}
		}
	}

	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if (TimeLord.freeze.contains(player.getName()) && !TimeLord.freezing.contains(player.getName())) {
			event.setTo(player.getLocation());
			player.sendMessage(String.valueOf(Main.NAME) + " §7» §cUm §e§lTIMELORD§c congelou o tempo.");
			Main.getPlugin().getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.getPlugin(),
					(Runnable) new Runnable() {
						@Override
						public void run() {
							TimeLord.freeze.remove(player.getName());
						}
					}, 150L);
		}
	}
}
