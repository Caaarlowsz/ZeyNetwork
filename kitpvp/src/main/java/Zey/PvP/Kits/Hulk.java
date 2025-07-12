package Zey.PvP.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import Zey.PvP.Essencial.Cooldown;
import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Hulk extends Kit implements Listener {

	public Hulk() {
		super("Hulk");
	}

	@EventHandler
	public void PickUpPlayer(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		if (e.getRightClicked() instanceof Player) {
			final Player p = e.getPlayer();
			if (KitPvPAPI.getKit(p).equals(Kits.HULK)) {
				final Player r = (Player) e.getRightClicked();
				if (Cooldown.add(p)) {
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
					return;
				}
				if (p.getItemInHand().getType() != Material.SADDLE) {
					return;
				}
				if (p.getPassenger() != null) {
					p.sendMessage(
							String.valueOf(Main.PREFIX) + " §7» §cAguarde o outro jogador(a) sair da sua cabeça.");
					return;
				}
				if (r.getPassenger() != null) {
					return;
				}
				Cooldown.add(p, 6);
				p.setPassenger((Entity) r);
				r.sendMessage(
						String.valueOf(Main.PREFIX) + " §7» Um Hulk lhe predeu Aperde §a§lSHIFT§7 para se soltar.");
			}
		}
	}
}