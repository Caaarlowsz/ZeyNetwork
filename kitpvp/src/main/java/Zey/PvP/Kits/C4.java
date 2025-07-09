package Zey.PvP.Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Essencial.Cooldown;
import Zey.PvP.Essencial.KitAPI;
import Zey.PvP.Essencial.KitUtil;
import Zey.PvP.Eventos.Habilidade;
import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Warps;

public class C4 implements Listener {
	public static HashMap<String, Item> bomba;

	static {
		C4.bomba = new HashMap<String, Item>();
	}

	@EventHandler
	public void aoBotar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("C4")) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (p.getItemInHand().getType() == Material.SLIME_BALL) {
					if (Cooldown.add(p)) {
						KitUtil.MensagemCooldown(p);
						return;
					}
					final Location loc = p.getLocation();
					final Vector vec = new Vector(0, 2, 0);
					final Location direc = loc.add(vec);
					final Item item = p.getWorld().dropItem(direc, new ItemStack(Material.TNT, 1));
					item.setVelocity(p.getEyeLocation().getDirection());
					C4.bomba.put(p.getName(), item);
					final ItemStack itemb = new ItemStack(Material.STONE_BUTTON);
					final ItemMeta itembm = itemb.getItemMeta();
					itembm.setDisplayName("§e§lC4");
					itemb.setItemMeta(itembm);
					p.getInventory().setItemInHand(itemb);
					p.updateInventory();
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cSua C4 foi implantada");
				}

				else if (p.getItemInHand().getType() == Material.STONE_BUTTON) {
					final ItemStack itemb2 = new ItemStack(Material.SLIME_BALL);
					final ItemMeta itembm2 = itemb2.getItemMeta();
					itembm2.setDisplayName("§e§lC4");
					itemb2.setItemMeta(itembm2);
					p.getInventory().setItemInHand(itemb2);
					final Item item2 = C4.bomba.get(p.getName());
					p.getWorld().createExplosion(item2.getLocation(), 2.5f);
					item2.getWorld().playEffect(item2.getLocation(), Effect.EXPLOSION_HUGE, 10);
					C4.bomba.remove(p.getName());
					item2.remove();
					p.updateInventory();
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua C4 foi ativada");
					Cooldown.add(p, 20);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
						@Override
						public void run() {
							KitUtil.ccooldown(p);
						}
					}, 400L);
				}
			} else if ((e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
					&& p.getItemInHand().getType() == Material.STONE_BUTTON) {
				if (Cooldown.add(p)) {
					KitUtil.MensagemCooldown(p);
					return;
				}
				final ItemStack itemb2 = new ItemStack(Material.SLIME_BALL);
				final ItemMeta itembm2 = itemb2.getItemMeta();
				itembm2.setDisplayName("§e§lC4");
				itemb2.setItemMeta(itembm2);
				p.getInventory().setItemInHand(itemb2);
				final Item item2 = C4.bomba.get(p.getName());
				C4.bomba.remove(p.getName());
				item2.remove();
				p.updateInventory();
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aC4 Desarmada");
			}
		}
	}

	@EventHandler
	public void aomorrer(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (C4.bomba.containsKey(p.getName())) {
			final Item item = C4.bomba.get(p.getName());
			item.remove();
			C4.bomba.remove(p.getName());

			ZeyCoins.removeMoney(p, 50);

			KitAPI.remove(p);
			Habilidade.removeAbility(p);
			p.setGameMode(GameMode.SURVIVAL);

			Main.getAPI().setWarp(p, Warps.SPAWN);
		}
	}
}
