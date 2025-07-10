package Zey.PvP.Essencial;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Zey.PvP.Main.Main;

public class KitUtil {
	public static void MensagemCooldown(final Player p) {
		p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
	}

	public static void ccooldown(final Player p) {
		p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSeu cooldown acabou.");
	}

	public static void tirarArmadura(final Player p) {
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
	}
}