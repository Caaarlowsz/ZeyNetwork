package Zey.PvP.Score;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import Zey.PvP.Main.Main;

@SuppressWarnings("all")
public class SManager {
	private static ConcurrentHashMap<UUID, SPlayer> players;

	static {
		SManager.players = new ConcurrentHashMap<UUID, SPlayer>();
	}

	public static ConcurrentHashMap<UUID, SPlayer> getPlayers() {
		return SManager.players;
	}

	public static void onEnable() {
		for (final Player player : Bukkit.getOnlinePlayers()) {
			SManager.players.put(player.getUniqueId(), new SPlayer(player.getName()));
			player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		}
		Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin) Main.getPlugin(), (Runnable) new Runnable() {
			@Override
			public synchronized void run() {
				for (final SPlayer player : SManager.players.values()) {
					player.updateScoreboard();
				}
			}
		}, 10L, 10L);
	}
}
