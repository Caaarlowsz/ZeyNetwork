package Zey.PvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import Zey.PvP.Essencial.Cooldown;
import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;

public class HotPotato extends Kit implements Listener {
	public static ArrayList<String> emhotpotato = new ArrayList<>();

	public HotPotato() {
		super("HotPotato");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(1, ItemUtils.item(Material.POTATO, "§e§lHOTPOTATO"));
	}

	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	public void onInteract(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			final Player k = (Player) e.getRightClicked();
			if (p.getItemInHand().getType().equals((Object) Material.POTATO)
					&& KitPvPAPI.getKit(p).equals(Kits.HOTPOTATO)) {
				if (Gladiator.lutando.containsKey(p.getName())) {
				} else {
					if (Cooldown.add(p)) {
						p.sendMessage(
								String.valueOf(Main.NAME) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
						return;
					}
					Cooldown.add(p, 20);
					HotPotato.emhotpotato.add(k.getName());
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §aHotPotato Colocada");
					k.sendMessage(String.valueOf(Main.NAME)
							+ " §7» §eVocê está com a tnt do hotpotato tire ou ira explodir em 5 segundos!");
					k.sendMessage(
							String.valueOf(Main.NAME) + " §7» §cClique com o botao direito na hotpotato para tira-la.");

					final ItemStack tnt = new ItemStack(Material.TNT);
					final ItemMeta tntmeta = tnt.getItemMeta();
					tntmeta.setDisplayName("§cTNT");
					tnt.setItemMeta(tntmeta);

					k.getInventory().setHelmet(tnt);

					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(String.valueOf(Main.NAME)
										+ " §7» §eVocê está com a tnt, ela será explodida em 4 segundos");
							}
						}
					}.runTaskLater((Plugin) Main.getPlugin(), 0L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(String.valueOf(Main.NAME)
										+ " §7» §eVocê está com a tnt, ela será explodida em 3 segundos");
							}
						}
					}.runTaskLater((Plugin) Main.getPlugin(), 20L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(String.valueOf(Main.NAME)
										+ " §7» §eVocê está com a tnt, ela será explodida em 2 segundos");
							}
						}
					}.runTaskLater((Plugin) Main.getPlugin(), 40L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(String.valueOf(Main.NAME)
										+ " §7» §e§lVocê está com a tnt, ela será explodida em 1 segundo");
							}
						}
					}.runTaskLater((Plugin) Main.getPlugin(), 60L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.getWorld().createExplosion(k.getLocation(), 3.0f, true);
								k.getWorld().playEffect(k.getLocation(), Effect.EXPLOSION_HUGE, 20);
								k.setLastDamage(9999.0);
								HotPotato.emhotpotato.remove(k.getName());
							}
						}
					}.runTaskLater((Plugin) Main.getPlugin(), 80L);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(String.valueOf(Main.NAME) + " §7» §aSeu cooldown acabou.");
						}
					}, 500L);
				}
			}
		}
	}

	@EventHandler
	public void onRemoverTNT(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (!KitPvPAPI.getKit(p).equals(Kits.NENHUM) && e.getSlot() == 39
				&& e.getCurrentItem().getType().equals((Object) Material.TNT)
				&& HotPotato.emhotpotato.contains(p.getName())) {
			HotPotato.emhotpotato.remove(p.getName());
			e.setCancelled(true);
			p.getInventory().setHelmet((ItemStack) null);
			p.playSound(p.getLocation(), Sound.CREEPER_HISS, 2.0f, 2.0f);
			p.sendMessage(String.valueOf(Main.NAME) + " §7» §aVocê desarmou a hotpotato.");
			p.closeInventory();
		}
	}
}