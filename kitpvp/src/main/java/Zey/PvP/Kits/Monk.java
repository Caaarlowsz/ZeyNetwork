package Zey.PvP.Kits;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import Zey.PvP.Essencial.Cooldown;
import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Monk extends Kit implements Listener {

	public Monk() {
		super("Monk");
	}

	@EventHandler
	public void aoMonk(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			final Player jogadorClicado = (Player) e.getRightClicked();
			if (KitPvPAPI.getKit(p).equals(Kits.MONK) && p.getItemInHand().getType() == Material.BLAZE_ROD) {
				if (Cooldown.add(p)) {
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
					return;
				}
				final int random = new Random().nextInt(jogadorClicado.getInventory().getSize() - 10 + 1 + 10);
				final ItemStack ItemSelecionado = jogadorClicado.getInventory().getItem(random);
				final ItemStack ItemMudado = jogadorClicado.getItemInHand();
				jogadorClicado.setItemInHand(ItemSelecionado);
				jogadorClicado.getInventory().setItem(random, ItemMudado);
				jogadorClicado.sendMessage(String.valueOf(Main.NAME) + " §7» §7Você foi §c§lMONKADO§7.");
				p.sendMessage(String.valueOf(String.valueOf(Main.NAME) + " §7» §7Você §c§lMONKOU§7 o jogador(a): §e"
						+ jogadorClicado.getName()));
				Cooldown.add(p, 20);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.sendMessage(String.valueOf(Main.NAME) + " §7» §aSeu cooldown acabou.");
					}
				}, 400L);
			}
		}
	}
}