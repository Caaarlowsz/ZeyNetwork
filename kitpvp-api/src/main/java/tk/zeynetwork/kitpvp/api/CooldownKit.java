package tk.zeynetwork.kitpvp.api;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class CooldownKit extends Kit {

	private HashMap<Player, Long> remaingTime = new HashMap<>();
	private HashMap<Player, BukkitTask> taskMap = new HashMap<>();

	public CooldownKit(String name) {
		super(name);
	}

	public boolean hasCooldown(Player player) {
		return this.remaingTime.containsKey(player);
	}

	public long getRemaingTime(Player player) {
		return (this.remaingTime.getOrDefault(player, System.currentTimeMillis()) - System.currentTimeMillis()) / 1000L;
	}

	public void addCooldown(Plugin plugin, Player player, int seconds) {
		this.remaingTime.put(player, System.currentTimeMillis() + (seconds + 1) * 1000);
		this.taskMap.put(player, Bukkit.getScheduler().runTaskLater(plugin, () -> this.removeCooldown(player), seconds * 20));
	}

	public void removeCooldown(Player player) {
		if (hasCooldown(player))
			this.remaingTime.remove(player);
		if (this.taskMap.containsKey(player))
			this.taskMap.remove(player).cancel();
	}
}