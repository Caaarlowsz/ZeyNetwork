package Zey.PvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Zey.PvP.Main.Main;
import Zey.PvP.Menus.MenuGeral1;
import Zey.PvP.Menus.MenuKits;
import Zey.PvP.Menus.MenuWarps;
import Zey.PvP.Warps.Parkour;

public class Direito implements Listener {
	@EventHandler
	public void AbrirMenuGeral(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.BOOK)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lMENU GERAL")
				&& Main.getAPI().getWarp(p).getName() == "Spawn") {

			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
				MenuGeral1.guiKits(p);
			}
		}
	}

	@EventHandler
	public void AbrirMenuKits(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.ENDER_CHEST)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lKITS")
				&& Main.getAPI().getWarp(p).getName() == "Spawn") {

			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
				MenuKits.GuiKit(p);
			}
		}
	}

	@EventHandler
	public void AbrirMenuWarps(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.PAPER)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lWARPS")
				&& Main.getAPI().getWarp(p).getName() == "Spawn") {

			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
				MenuWarps.guiKits(p);
			}
		}
	}

	@EventHandler
	public void ReiniciarParkour(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.REDSTONE)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")
				&& Main.getAPI().getWarp(p).getName() == "Parkour") {

			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
				final World w = Bukkit.getServer().getWorld(Parkour.plugin.getConfig().getString("parkour.world"));
				final double x = Parkour.plugin.getConfig().getDouble("parkour.x");
				final double y = Parkour.plugin.getConfig().getDouble("parkour.y");
				final double z = Parkour.plugin.getConfig().getDouble("parkour.z");
				final Location lobby = new Location(w, x, y, z);
				lobby.setPitch((float) Parkour.plugin.getConfig().getDouble("parkour.pitch"));
				lobby.setYaw((float) Parkour.plugin.getConfig().getDouble("parkour.yaw"));
				p.teleport(lobby);
				p.setHealthScale(20.0);
			}
		}
	}
}
