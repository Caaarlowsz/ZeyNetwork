package Zey.PvP.Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.CooldownKit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;

public class Armor extends CooldownKit implements Listener {
	public static HashMap<String, ItemStack[]> salvararmor = new HashMap<>();

	public Armor() {
		super("Armor");
	}

	@Override
	public void giveItems(Player player) {
		super.giveItems(player);
		player.getInventory().setItem(1, ItemUtils.item(Material.GOLD_INGOT, "§e§lARMOR"));
	}

	public static ItemStack darArmaduraI(final Material material) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta itemm = item.getItemMeta();
		item.setItemMeta(itemm);
		return item;
	}

	@EventHandler
	public void aoArmor(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitPvPAPI.getKit(p).equals(Kits.ARMOR)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.GOLD_INGOT) {
			if (this.hasCooldown(p)) {
				p.sendMessage(String.valueOf(Main.NAME) + " §7» §cAguarde " + this.getRemaingTime(p) + " segundos");
				return;
			}
			Armor.salvararmor.put(p.getName(), p.getInventory().getArmorContents());
			p.getInventory().setArmorContents(null);
			p.sendMessage(String.valueOf(Main.NAME) + " §7» §7Você recebeu sua armadura temporaria.");
			p.getInventory()
					.setArmorContents(new ItemStack[] { darArmaduraI(Material.GOLD_HELMET),
							darArmaduraI(Material.GOLD_CHESTPLATE), darArmaduraI(Material.GOLD_LEGGINGS),
							darArmaduraI(Material.GOLD_BOOTS) });
			p.updateInventory();
			this.addCooldown(Main.getPlugin(), p, 25);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getInventory().setArmorContents(null);
					p.getInventory().setArmorContents((ItemStack[]) Armor.salvararmor.get(p.getName()));
					Armor.salvararmor.remove(p.getName());
					p.updateInventory();
				}
			}, 200L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(Main.NAME) + " §7» §aSeu cooldown acabou.");
				}
			}, 500L);
		}

	}

	@EventHandler
	public void aomecher(final InventoryClickEvent e) {
		try {
			final Player p = (Player) e.getWhoClicked();
			if (Armor.salvararmor.containsKey(p.getName())
					&& e.getSlotType().equals((Object) InventoryType.SlotType.ARMOR)) {
				e.setCancelled(true);
			}
		} catch (Exception ex) {
		}
	}
}