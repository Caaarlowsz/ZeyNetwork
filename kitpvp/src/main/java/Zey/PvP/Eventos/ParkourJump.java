package Zey.PvP.Eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Main.Main;
import Zey.PvP.Warps.Parkour;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class ParkourJump implements Listener {
	public static ArrayList<String> jump;
	ArrayList<String> nofalldamage = new ArrayList<>();
	ArrayList<String> nofalldamagewait = new ArrayList<>();

	static {
		ParkourJump.jump = new ArrayList<String>();
	}

	@EventHandler
	public void onPlayerJumpBaixo(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK
				&& KitPvPAPI.getWarp(p).getName() == "Parkour") {

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
			ZeyCoins.addMoney(p, 200);
			p.sendMessage(String.valueOf(Main.PREFIX) + " §7§ §aVocê terminou o Parkour");
			p.sendMessage(String.valueOf(Main.PREFIX) + " §7§ §aVocê ganhou 200 ZeyCoins!");
		}
	}

	@EventHandler
	public void onEntityDamage(final EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			final Player player = (Player) event.getEntity();
			if (this.nofalldamage.contains(player.getName())
					&& event.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)) {
				event.setCancelled(true);
				this.nofalldamage.remove(player.getName());
			}
		}
	}
}
