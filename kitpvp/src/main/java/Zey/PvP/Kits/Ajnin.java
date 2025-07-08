package Zey.PvP.Kits;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Zey.PvP.Essencial.Cooldown;
import Zey.PvP.Essencial.KitUtil;
import Zey.PvP.Eventos.Habilidade;
import Zey.PvP.Main.Main;

public class Ajnin implements Listener {
	public HashMap<Player, Player> ajinhash;
	public HashMap<Player, Long> ajincooldown;

	public Ajnin() {
		this.ajinhash = new HashMap<Player, Player>();
		this.ajincooldown = new HashMap<Player, Long>();
	}

	@EventHandler
	public void a(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			final Player p = (Player) e.getDamager();
			final Player t = (Player) e.getEntity();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Ajnin")) {
				this.ajinhash.put(p, t);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
					}
				}, 200L);
			}
		}
	}

	@EventHandler
	public void aPlayerToggle(final PlayerToggleSneakEvent e) {
		final Player p = e.getPlayer();
		if (Cooldown.add(p)) {
			KitUtil.MensagemCooldown(p);
			return;
		}
		if (e.isSneaking() && Habilidade.getAbility(p).equalsIgnoreCase("Ajnin") && this.ajinhash.containsKey(p)) {
			final Player t = this.ajinhash.get(p);
			if (t != null && !t.isDead()) {
				if (this.ajincooldown.get(p) != null) {
					new DecimalFormat("##");
				}
				if (p.getLocation().distance(t.getLocation()) < 200.0) {
					t.teleport(p.getLocation());
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §aVocê teleportou o jogador(a) para você.");
					Cooldown.add(p, 3);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
						@Override
						public void run() {
							KitUtil.ccooldown(p);
						}
					}, 140L);
				} else {
					p.sendMessage(String.valueOf(Main.prefix)
							+ " §7» §cO ultimo jogador(a) hitado se afastou muito de voc§.");
				}
			}
		}
	}

	@EventHandler
	public void aomorrer(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		final Player t = this.ajinhash.get(p);
		this.ajinhash.remove(t);
		this.ajinhash.remove(p);
	}

	@EventHandler
	public void aosair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		final Player t = this.ajinhash.get(p);
		this.ajinhash.remove(t);
		this.ajinhash.remove(p);
	}
}
