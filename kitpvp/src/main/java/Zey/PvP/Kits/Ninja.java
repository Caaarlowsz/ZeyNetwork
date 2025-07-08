package Zey.PvP.Kits;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Zey.PvP.Essencial.KitAPI;
import Zey.PvP.Main.Main;

public class Ninja implements Listener {
	public static HashMap<Player, Player> a;
	public static HashMap<Player, Long> b;
	public static List<Player> cooldownbk;

	static {
		Ninja.a = new HashMap<Player, Player>();
		Ninja.b = new HashMap<Player, Long>();
		Ninja.cooldownbk = new ArrayList<Player>();
	}

	@EventHandler
	public void a(final EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
		if (paramEntityDamageByEntityEvent.getDamager() instanceof Player
				&& paramEntityDamageByEntityEvent.getEntity() instanceof Player) {
			final Player localPlayer1 = (Player) paramEntityDamageByEntityEvent.getDamager();
			final Player localPlayer2 = (Player) paramEntityDamageByEntityEvent.getEntity();
			if (KitAPI.Ninja.contains(localPlayer1.getName())) {
				Ninja.a.put(localPlayer1, localPlayer2);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						Ninja.cooldownbk.remove(localPlayer1);
					}
				}, 60L);
			}
		}
	}

	@EventHandler
	public void a(final PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
		final Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
		final Player localPlayer2;
		if (paramPlayerToggleSneakEvent.isSneaking() && KitAPI.Ninja.contains(localPlayer1.getName())
				&& Ninja.a.containsKey(localPlayer1) && (localPlayer2 = Ninja.a.get(localPlayer1)) != null
				&& !localPlayer2.isDead()) {
			String str = null;
			if (Ninja.b.get(localPlayer1) != null) {
				final long l = Ninja.b.get(localPlayer1) - System.currentTimeMillis();
				final DecimalFormat localDecimalFormat = new DecimalFormat("##");
				final int i = (int) l / 1000;
				str = localDecimalFormat.format(i);
			}
			if (Ninja.b.get(localPlayer1) == null || Ninja.b.get(localPlayer1) < System.currentTimeMillis()) {
				if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0) {
					localPlayer1.teleport(localPlayer2.getLocation());
					localPlayer1.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aVocê usou seu ninja.");
					Ninja.b.put(localPlayer1, System.currentTimeMillis() + 3000L);
				} else {
					localPlayer1.sendMessage(String.valueOf(Main.PREFIX)
							+ " §7» §cO ultimo jogador(a) hitado se afastou muito de você.");
				}
			} else {
				localPlayer1.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cAguarde " + str + " segundos");
			}
		}
	}
}
