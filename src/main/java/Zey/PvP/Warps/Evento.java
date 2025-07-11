package Zey.PvP.Warps;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Zey.PvP.APIs.TheTitle;
import Zey.PvP.Commands.BuildCommand;
import Zey.PvP.Essencial.KitAPI;
import Zey.PvP.Eventos.Habilidade;
import Zey.PvP.Main.Main;
import Zey.PvP.Utils.Proteção;

@SuppressWarnings("unused")
public class Evento implements Listener, CommandExecutor {
	public static Main plugin;

	public Evento(final Main main) {
		Evento.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {

		if (cmd.getName().equalsIgnoreCase("evento")) {
			final Player d = (Player) sender;
			if (!Zey.PvP.Commands.IniciarCommand.evento) {
				d.sendMessage(String.valueOf(Main.prefix) + " §7» §cNão é possivel acessar essa Warp, nesse momento.");
				return true;
			}
			final Player p = (Player) sender;

			final World w = Bukkit.getServer().getWorld(Evento.plugin.getConfig().getString("evento.world"));
			final double x = Evento.plugin.getConfig().getDouble("evento.x");
			final double y = Evento.plugin.getConfig().getDouble("evento.y");
			final double z = Evento.plugin.getConfig().getDouble("evento.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) Evento.plugin.getConfig().getDouble("evento.pitch"));
			lobby.setYaw((float) Evento.plugin.getConfig().getDouble("evento.yaw"));

			p.getInventory().clear();
			p.setHealthScale(1.0);
			p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você está sendo teleportando para Warp §a§lEVENTO");
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Evento.plugin, (Runnable) new Runnable() {

				@SuppressWarnings("deprecation")
				@Override
				public void run() {
					p.teleport(lobby);
					p.getInventory().clear();
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §aTeleportado com sucesso");

					TheTitle.sendTitle(p, "§e§lEVENTO");

					if (p.hasPermission("zey.pvp.admin") && Zey.PvP.APIs.WarpAPI.getWarp(p) == "Nenhuma") {
						Main.admins.remove(p.getName());
						p.sendMessage(String.valueOf(Main.prefix) + " §7» Você saiu do modo §c§lADMIN");

						for (Player players : Bukkit.getOnlinePlayers()) {
							players.showPlayer(p);
						}
					}

					p.setAllowFlight(false);
					p.setFlying(false);

					KitAPI.remove(p);
					Habilidade.removeAbility(p);
					KitAPI.removeAbility(p);
					BuildCommand.embuild.remove(p);
					p.setGameMode(GameMode.SURVIVAL);

					Zey.PvP.APIs.WarpAPI.setWarp(p, "Evento");

					p.getInventory().setBoots((ItemStack) null);
					p.getInventory().setChestplate(null);
					p.getInventory().setLeggings((ItemStack) null);
					p.getInventory().setHelmet((ItemStack) null);
					p.setHealthScale(20.0);

					Proteção.setImortal(p, false);
					Proteção.isImortal(p);

					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().setItem(0, espada);

					final ItemStack sopas = new ItemStack(Material.BOWL, 64);
					final ItemMeta ksopas = sopas.getItemMeta();
					sopas.setItemMeta(ksopas);
					final ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
					final ItemMeta kcogur = cogur.getItemMeta();
					cogur.setItemMeta(kcogur);
					final ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
					final ItemMeta kcogum = cogum.getItemMeta();
					cogum.setItemMeta(kcogum);

					p.getInventory().setItem(13, sopas);
					p.getInventory().setItem(14, cogur);
					p.getInventory().setItem(15, cogum);

					p.setFireTicks(0);
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
					for (final PotionEffect effect : p.getActivePotionEffects()) {
						p.removePotionEffect(effect.getType());
					}
				}
			}, 10L);
		}
		return false;
	}
}
