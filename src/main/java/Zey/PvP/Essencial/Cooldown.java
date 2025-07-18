package Zey.PvP.Essencial;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Zey.PvP.Main.Main;

public class Cooldown implements Listener {
	public static HashMap<Player, Long> run;

	static {
		Cooldown.run = new HashMap<Player, Long>();
	}

	public static void add(final Player p, final int seconds) {
		final long CoolDownLength = System.currentTimeMillis() + seconds * 1000;
		Cooldown.run.remove(p);
		Cooldown.run.put(p, CoolDownLength);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
			@Override
			public void run() {
				Cooldown.run.remove(p);
			}
		}, (long) (seconds * 20));
	}

	public static long CoolDown(final Player p) {
		final long CoolDownLength = Cooldown.run.get(p);
		final long left = (CoolDownLength - System.currentTimeMillis()) / 1000L;
		return left;
	}

	public static boolean add(final Player p) {
		return Cooldown.run.containsKey(p);
	}

	public static void remove(final Player p) {
		Cooldown.run.remove(p);
	}
}
