package Zey.PvP.Config;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import Zey.PvP.Main.Main;

public class Status implements Listener {
	@EventHandler
	void aoLogar(PlayerJoinEvent evento) {
		/* 17 */ Player jogador = evento.getPlayer();
		/* 18 */ if (Main.getPlugin().getConfig().get("status." + jogador.getName().toLowerCase() + ".kills") == null) {
			/* 20 */ Main.getPlugin().getConfig().set("status." + jogador.getName().toLowerCase() + ".kills",
					Integer.valueOf(0));
			/* 21 */ Main.getPlugin().saveConfig();
		}
		/* 23 */ if (Main.getPlugin().getConfig()
				.get("status." + jogador.getName().toLowerCase() + ".mortes") == null) {
			/* 25 */ Main.getPlugin().getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes",
					Integer.valueOf(0));
			/* 26 */ Main.getPlugin().saveConfig();
		}
	}

	@EventHandler
	void aoMatar(PlayerDeathEvent evento) {
		/* 33 */ if ((evento.getEntity().getKiller() instanceof Player)) {
			/* 35 */ Player jogador = evento.getEntity().getKiller();

			/* 37 */ int kills = Main.getPlugin().getConfig()
					.getInt("status." + jogador.getName().toLowerCase() + ".kills");
			/* 38 */ Main.getPlugin().getConfig().set("status." + jogador.getName().toLowerCase() + ".kills",
					Integer.valueOf(kills + 1));
			/* 39 */ Main.getPlugin().saveConfig();
		}
	}

	@EventHandler
	void aoMorrer(PlayerDeathEvent evento) {
		/* 46 */ if ((evento.getEntity() instanceof Player)) {
			/* 48 */ Player jogador = evento.getEntity();

			/* 50 */ int mortes = Main.getPlugin().getConfig()
					.getInt("status." + jogador.getName().toLowerCase() + ".mortes");
			/* 51 */ Main.getPlugin().getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes",
					Integer.valueOf(mortes + 1));
			/* 52 */ Main.getPlugin().saveConfig();
		}
	}

	/* 56 */ public static int getKills(Player p) {
		return Main.getPlugin().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
	}

}
