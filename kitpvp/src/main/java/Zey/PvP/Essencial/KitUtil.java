package Zey.PvP.Essencial;

import org.bukkit.entity.Player;

import Zey.PvP.Main.Main;

public class KitUtil {
	public static void MensagemCooldown(final Player p) {
		p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
	}

	public static void ccooldown(final Player p) {
		p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSeu cooldown acabou.");
	}
}