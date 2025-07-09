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
public class TheMain extends Warp implements CommandExecutor {
	public static Main plugin = Main.getPlugin();

	public TheMain() {
		super("Main");
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("main")) {
			final Player p = (Player) sender;
			final World w = Bukkit.getServer().getWorld(TheMain.plugin.getConfig().getString("themain.world"));
			final double x = TheMain.plugin.getConfig().getDouble("themain.x");
			final double y = TheMain.plugin.getConfig().getDouble("themain.y");
			final double z = TheMain.plugin.getConfig().getDouble("themain.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) TheMain.plugin.getConfig().getDouble("themain.pitch"));
			lobby.setYaw((float) TheMain.plugin.getConfig().getDouble("themain.yaw"));
			p.getInventory().clear();
			p.setHealthScale(1.0);
			p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você está sendo teleportando para Warp §a§lMAIN");
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) TheMain.plugin, (Runnable) new Runnable() {
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
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aTeleportado com sucesso");

					p.setAllowFlight(false);
					p.setFlying(false);

					TheTitle.sendTitle(p, "§e§lMAIN");

					KitPvPAPI api = Main.getAPI();
					
					if (p.hasPermission("zey.pvp.admin") && api.getWarp(p).getName() == "Nenhuma") {
						Main.admins.remove(p.getName());
						p.sendMessage(String.valueOf(Main.PREFIX) + " §7» Você saiu do modo §c§lADMIN");

						for (Player players : Bukkit.getOnlinePlayers()) {
							players.showPlayer(p);
						}
					}

					KitAPI.remove(p);
					Habilidade.removeAbility(p);
					BuildCommand.embuild.remove(p);
					p.setGameMode(GameMode.SURVIVAL);

					api.setWarp(p, Warps.MAIN);

					Proteção.setImortal(p, false);
					Proteção.isImortal(p);

					final ItemStack peito = new ItemStack(Material.DIAMOND_CHESTPLATE);
					final ItemMeta peito2 = peito.getItemMeta();
					peito2.setDisplayName("§e§lPEITORAL");
					peito.setItemMeta(peito2);
					p.getInventory().setBoots((ItemStack) null);
					p.getInventory().setChestplate(peito);
					p.getInventory().setLeggings((ItemStack) null);
					p.getInventory().setHelmet((ItemStack) null);
					p.setHealthScale(20.0);
					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().setItem(0, espada);
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
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
				}
			}, 90L);
			return false;
		}
		return false;
	}
}
