package Zey.PvP.Warps;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
import tk.zeynetwork.kitpvp.Warps;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.kitpvp.api.Warp;

@SuppressWarnings("unused")
public class Lava extends Warp implements CommandExecutor {
	public static Main plugin = Main.getPlugin();

	public Lava() {
		super("Challenge");
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("challenge")) {
			final Player p = (Player) sender;
			p.setFlying(false);
			p.setAllowFlight(false);
			p.setGameMode(GameMode.SURVIVAL);

			final World w = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("lava.world"));
			final double x = Main.getPlugin().getConfig().getDouble("lava.x");
			final double y = Main.getPlugin().getConfig().getDouble("lava.y");
			final double z = Main.getPlugin().getConfig().getDouble("lava.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) Main.getPlugin().getConfig().getDouble("lava.pitch"));
			lobby.setYaw((float) Main.getPlugin().getConfig().getDouble("lava.yaw"));

			p.getInventory().clear();
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você está sendo teleportando para Warp §a§lCHALLENGE");
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getPlugin(), (Runnable) new Runnable() {

				@SuppressWarnings("deprecation")
				@Override
				public void run() {
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aTeleportado com sucesso");

					TheTitle.sendTitle(p, "§e§lCHALLENGE");

					KitPvPAPI api = Main.getAPI();
					if (p.hasPermission("zey.pvp.admin") && api.getWarp(p).getName() == "Nenhuma") {
						Main.admins.remove(p.getName());
						p.sendMessage(String.valueOf(Main.PREFIX) + " §7» Você saiu do modo §c§lADMIN");

						for (Player players : Bukkit.getOnlinePlayers()) {
							players.showPlayer(p);
						}
					}

					p.setAllowFlight(false);
					p.setFlying(false);

					KitAPI.remove(p);
					Habilidade.removeAbility(p);
					BuildCommand.embuild.remove(p);
					p.setGameMode(GameMode.SURVIVAL);

					Proteção.setImortal(p, false);
					Proteção.isImortal(p);

					api.setWarp(p, Warps.CHALLENGE);

					p.getInventory().setBoots((ItemStack) null);
					p.getInventory().setChestplate((ItemStack) null);
					p.getInventory().setLeggings((ItemStack) null);
					p.getInventory().setHelmet((ItemStack) null);

					p.setFireTicks(0);

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
					p.teleport(lobby);
					for (final PotionEffect effect : p.getActivePotionEffects()) {
						p.removePotionEffect(effect.getType());
					}
				}
			}, 90L);
		}
		return false;
	}
}
