package Zey.PvP.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.Vector;

import Zey.PvP.Essencial.KitAPI;
import Zey.PvP.Essencial.KitUtil;
import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.api.Kit;

public class DeshFire extends Kit implements Listener {
	public int boost = 6;
	public static ArrayList<String> Deshfire = new ArrayList<>();
	public static HashMap<String, ItemStack[]> Armadura = new HashMap<>();
	public static HashMap<String, ItemStack[]> saveinv = new HashMap<>();
	public static HashMap<String, ItemStack[]> armadura = new HashMap<>();
	public static HashMap<String, ItemStack[]> Armadura2 = new HashMap<>();
	public static List<Player> cooldownm = new ArrayList<>();
	
	public DeshFire() {
		super("DeshFire");
	}

	@EventHandler
	public void DeshClick(final PlayerInteractEvent event) {
		final int fire = Integer.valueOf(6);
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.REDSTONE_BLOCK
				&& KitAPI.DeshFire.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (DeshFire.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cAguarde o cooldown terminar.");
				return;
			}
			DeshFire.cooldownm.add(p);
			p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
			p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
			p.getLocation();
			for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (pertos instanceof Player) {
					((Player) pertos).damage(10.0);
					pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
					((Player) pertos).setFireTicks(fire * 20);
				}
			}
			final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
			final LeatherArmorMeta kCapacete = (LeatherArmorMeta) Capacete.getItemMeta();
			kCapacete.setColor(Color.RED);
			Capacete.setItemMeta((ItemMeta) kCapacete);
			final ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
			final LeatherArmorMeta kPeitoral = (LeatherArmorMeta) Peitoral.getItemMeta();
			kPeitoral.setColor(Color.RED);
			Peitoral.setItemMeta((ItemMeta) kPeitoral);
			final ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
			final LeatherArmorMeta kCalss = (LeatherArmorMeta) Calss.getItemMeta();
			kCalss.setColor(Color.RED);
			Calss.setItemMeta((ItemMeta) kCalss);
			final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
			final LeatherArmorMeta kBota = (LeatherArmorMeta) Capacete.getItemMeta();
			kBota.setColor(Color.RED);
			Bota.setItemMeta((ItemMeta) kBota);
			DeshFire.Armadura.put(p.getName(), p.getInventory().getArmorContents());
			p.getInventory().setHelmet(Capacete);
			p.getInventory().setChestplate(Peitoral);
			p.getInventory().setLeggings(Calss);
			p.getInventory().setBoots(Bota);
			p.updateInventory();
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getInventory().setArmorContents((ItemStack[]) null);
					p.updateInventory();
				}
			}, 50L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@SuppressWarnings("unlikely-arg-type")
				@Override
				public void run() {
					DeshFire.cooldownm.remove(p);
					DeshFire.Deshfire.remove(p);
					KitUtil.ccooldown(p);
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
				}
			}, 700L);
		}
	}
}
