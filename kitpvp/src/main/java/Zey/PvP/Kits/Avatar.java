package Zey.PvP.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import Zey.PvP.Essencial.Cooldown;
import Zey.PvP.Main.Main;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;

public class Avatar extends Kit implements Listener {
	public static List<String> arAvatar = new ArrayList<>();
	public static List<String> águaAvatar = new ArrayList<>();
	public static List<String> terraAvatar = new ArrayList<>();
	public static List<String> fogoAvatar = new ArrayList<>();

	public Avatar() {
		super("Avatar");
	}

	@EventHandler
	public void aoAvatar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitPvPAPI.getKit(p).equals(Kits.AVATAR)) {
			final ItemStack ar = new ItemStack(Material.WOOL);
			final ItemMeta arm = ar.getItemMeta();
			arm.setDisplayName("§eAvatar§7 (§f§lAR§7)");
			ar.setItemMeta(arm);
			final ItemStack água = new ItemStack(Material.LAPIS_BLOCK);
			final ItemMeta águam = água.getItemMeta();
			águam.setDisplayName("§eAvatar§7 (§1§lÁGUA§7)");
			água.setItemMeta(águam);
			final ItemStack terra = new ItemStack(Material.GRASS);
			final ItemMeta terram = terra.getItemMeta();
			terram.setDisplayName("§eAvatar§7 (§2§lTERRA§7)");
			terra.setItemMeta(terram);
			final ItemStack fogo = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta fogom = fogo.getItemMeta();
			fogom.setDisplayName("§eAvatar§7 (§4§lFOGO§7)");
			fogo.setItemMeta(fogom);
			if ((e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
					&& p.getItemInHand().getType() == Material.BEACON) {
				p.setItemInHand(ar);
				Avatar.arAvatar.add(p.getName());
			} else if (Avatar.arAvatar.contains(p.getName())
					&& (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
					&& p.getItemInHand().equals((Object) ar)) {
				p.setItemInHand(água);
				Avatar.arAvatar.remove(p.getName());
				Avatar.águaAvatar.add(p.getName());
			} else if (Avatar.águaAvatar.contains(p.getName())
					&& (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
					&& p.getItemInHand().equals((Object) água)) {
				p.setItemInHand(terra);
				Avatar.águaAvatar.remove(p.getName());
				Avatar.terraAvatar.add(p.getName());
			} else if (Avatar.terraAvatar.contains(p.getName())
					&& (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
					&& p.getItemInHand().equals((Object) terra)) {
				p.setItemInHand(fogo);
				Avatar.terraAvatar.remove(p.getName());
				Avatar.fogoAvatar.add(p.getName());
			} else if (Avatar.fogoAvatar.contains(p.getName())
					&& (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
					&& p.getItemInHand().equals((Object) fogo)) {
				p.setItemInHand(ar);
				Avatar.fogoAvatar.remove(p.getName());
				Avatar.arAvatar.add(p.getName());
			}
		}
	}

	@EventHandler
	public void ar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitPvPAPI.getKit(p).equals(Kits.AVATAR)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.WOOL) {
			e.setCancelled(true);
			p.updateInventory();
			if (Cooldown.add(p)) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
				return;
			}
			Cooldown.add(p, 30);
			final Location location = p.getEyeLocation();
			final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
			while (blocksToAdd.hasNext()) {
				final Location blockToAdd = blocksToAdd.next().getLocation();
				p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.WOOL, 15);
				p.playSound(blockToAdd, Sound.FIREWORK_BLAST, 3.0f, 3.0f);
			}
			final Snowball h = (Snowball) p.launchProjectile((Class<? extends Projectile>) Snowball.class);
			final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
			h.setVelocity(velo1);
			h.setMetadata("ar", (MetadataValue) new FixedMetadataValue(Main.getPlugin(), (Object) true));
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSeu cooldown acabou.");
				}
			}, 600L);
		}
	}

	@EventHandler
	public void danoar(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
			final Snowball s = (Snowball) e.getDamager();
			if (s.hasMetadata("ar")) {
				((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 2),
						true);
				e.setDamage(e.getDamage() + 8.0);
			}
		}
	}

	@EventHandler
	public void água(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitPvPAPI.getKit(p).equals(Kits.AVATAR)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.LAPIS_BLOCK) {
			e.setCancelled(true);
			p.updateInventory();
			if (Cooldown.add(p)) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
				return;
			}
			Cooldown.add(p, 30);
			final Location location = p.getEyeLocation();
			final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
			while (blocksToAdd.hasNext()) {
				final Location blockToAdd = blocksToAdd.next().getLocation();
				p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.LAPIS_BLOCK, 15);
				p.playSound(blockToAdd, Sound.FIREWORK_BLAST, 3.0f, 3.0f);
			}
			final Snowball h = (Snowball) p.launchProjectile((Class<? extends Projectile>) Snowball.class);
			final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
			h.setVelocity(velo1);
			h.setMetadata("água", (MetadataValue) new FixedMetadataValue(Main.getPlugin(), (Object) true));
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSeu cooldown acabou.");
				}
			}, 600L);
		}
	}

	@EventHandler
	public void danoágua(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
			final Snowball s = (Snowball) e.getDamager();
			if (s.hasMetadata("água")) {
				((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 1), true);
				e.setDamage(e.getDamage() + 8.0);
			}
		}
	}

	@EventHandler
	public void terra(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitPvPAPI.getKit(p).equals(Kits.AVATAR)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.GRASS) {
			e.setCancelled(true);
			p.updateInventory();
			if (Cooldown.add(p)) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
				return;
			}
			Cooldown.add(p, 30);
			final Location location = p.getEyeLocation();
			final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
			while (blocksToAdd.hasNext()) {
				final Location blockToAdd = blocksToAdd.next().getLocation();
				p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GRASS, 15);
				p.playSound(blockToAdd, Sound.FIREWORK_BLAST, 3.0f, 3.0f);
			}
			final Snowball h = (Snowball) p.launchProjectile((Class<? extends Projectile>) Snowball.class);
			final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
			h.setVelocity(velo1);
			h.setMetadata("terra", (MetadataValue) new FixedMetadataValue(Main.getPlugin(), (Object) true));
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSeu cooldown acabou.");
				}
			}, 600L);
		}
	}

	@EventHandler
	public void danoterra(final EntityDamageByEntityEvent e) {
		final Entity Player1 = e.getEntity();
		if (e.getDamager() instanceof Snowball) {
			final Snowball Player2 = (Snowball) e.getDamager();
			if (Player2.hasMetadata("terra")) {
				e.setDamage(8.0);
				final Vector vector = Player1.getLocation().getDirection();
				vector.multiply(-3.2f);
				Player1.setVelocity(vector);
			}
		}
	}

	@EventHandler
	public void fogo(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitPvPAPI.getKit(p).equals(Kits.AVATAR)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.REDSTONE_BLOCK) {
			e.setCancelled(true);
			p.updateInventory();
			if (Cooldown.add(p)) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
				return;
			}
			Cooldown.add(p, 30);
			final Location location = p.getEyeLocation();
			final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
			while (blocksToAdd.hasNext()) {
				final Location blockToAdd = blocksToAdd.next().getLocation();
				p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.REDSTONE_BLOCK, 15);
				p.playSound(blockToAdd, Sound.FIREWORK_BLAST, 3.0f, 3.0f);
			}
			final Snowball h = (Snowball) p.launchProjectile((Class<? extends Projectile>) Snowball.class);
			final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
			h.setVelocity(velo1);
			h.setMetadata("fogo", (MetadataValue) new FixedMetadataValue(Main.getPlugin(), (Object) true));
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSeu cooldown acabou.");
				}
			}, 600L);
		}
	}

	@EventHandler
	public void danofogo(final EntityDamageByEntityEvent e) {
		final Entity player1 = e.getEntity();
		if (e.getDamager() instanceof Snowball) {
			final Snowball player2 = (Snowball) e.getDamager();
			if (player2.hasMetadata("fogo")) {
				e.setDamage(8.0);
				player1.setFireTicks(100);
			}
		}
	}
}