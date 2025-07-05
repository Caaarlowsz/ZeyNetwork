package Zey.PvP.APIs;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class Habilidade {
	public static Map<String, String> powerMap;

	static {
		Habilidade.powerMap = new HashMap<>();
	}

	public static String getAbility(final Player player) {
		if (!Habilidade.powerMap.containsKey(player.getName()))
			Habilidade.powerMap.put(player.getName(), "Nenhum");
		return Habilidade.powerMap.get(player.getName());
	}

	public static void setAbility(final Player player, final String ability) {
		Habilidade.powerMap.put(player.getName(), ability);
	}

	public static void removeAbility(final Player p) {
		Habilidade.powerMap.remove(p.getName());
	}
}