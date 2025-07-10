package Zey.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import Zey.PvP.Essencial.KitUtil;
import Zey.PvP.Main.Main;
import Zey.PvP.Utils.Proteção;
import tk.zeynetwork.kitpvp.Kits;
import tk.zeynetwork.kitpvp.Warps;
import tk.zeynetwork.kitpvp.api.KitPvP;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ItemUtils;
import tk.zeynetwork.utils.TitleAPI;

public class KitCommand implements CommandExecutor {
	public KitCommand(final Main main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		KitPvP api = KitPvPAPI.getInstance();
		String warp = api.getWarp(p).getName();
		if (label.equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cErrado, utilize a sintaxe correta: /kit (kit)");
				return true;
			}

			if (warp == "Nenhuma") {
				p.sendMessage(String.valueOf(Main.PREFIX)
						+ " §7» §cNo momento, você está no /admin. Para pegar um kit, volte ao spawn usando o comando: /spawn");
				return true;
			}
			if (warp == "Arena") {
				p.sendMessage(String.valueOf(Main.PREFIX)
						+ " §7» §cVocê já está utilizando um Kit. Para pegar outro, volte ao spawn usando o comando: /spawn");
				return true;
			}
			if (warp == "Evento") {
				p.sendMessage(String.valueOf(Main.PREFIX)
						+ " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
				return true;
			}
			if (warp == "Fps") {
				p.sendMessage(String.valueOf(Main.PREFIX)
						+ " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
				return true;
			}
			if (warp == "Challenge") {
				p.sendMessage(String.valueOf(Main.PREFIX)
						+ " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
				return true;
			}
			if (warp == "Parkour") {
				p.sendMessage(String.valueOf(Main.PREFIX)
						+ " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
				return true;
			}
			if (warp == "Main") {
				p.sendMessage(String.valueOf(Main.PREFIX)
						+ " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
				return true;
			}
		}

		if (p.hasPermission("zey.pvp.admin") && warp == "Nenhuma") {
			Main.admins.remove(p.getName());
			p.sendMessage(String.valueOf(Main.PREFIX) + " §7» Você saiu do modo §c§lADMIN");

			for (Player players : Bukkit.getOnlinePlayers()) {
				players.showPlayer(p);
			}
		}

		Proteção.setImortal(p, false);
		Proteção.isImortal(p);

		if (args[0].equalsIgnoreCase("pvp")) {
			p.getInventory().clear();
			api.setKit(p, Kits.PVP);
			p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lPVP");
			TitleAPI.sendTitle(p, "§e§lPVP");
			SetArenaCommand.TeleportArenaRandom(p);
		}
		if (args[0].equalsIgnoreCase("ajnin")) {
			if (p.hasPermission("kit.ajnin") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.AJNIN);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lAJNIN");
				TitleAPI.sendTitle(p, "§e§lAJNIN");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("camel")) {
			if (p.hasPermission("kit.camel") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.CAMEL);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lCamel");
				TitleAPI.sendTitle(p, "§e§lCAMEL");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("anchor")) {
			if (p.hasPermission("kit.anchor") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.ANCHOR);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lANCHOR");
				TitleAPI.sendTitle(p, "§e§lANCHOR");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("armor")) {
			if (p.hasPermission("kit.armor") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.ARMOR);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lARMOR");
				p.getInventory().setItem(1, ItemUtils.item(Material.GOLD_INGOT, "§e§lARMOR"));
				TitleAPI.sendTitle(p, "§e§lARMOR");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("rain")) {
			if (p.hasPermission("kit.rain") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.RAIN);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lRAIN");
				p.getInventory().setItem(1, ItemUtils.item(Material.ARROW, "§e§lRAIN"));
				TitleAPI.sendTitle(p, "§e§lRAIN");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("timelord")) {
			if (p.hasPermission("kit.timelord") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.TIMELORD);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lTIMELORD");
				p.getInventory().setItem(1, ItemUtils.item(Material.WATCH, "§e§lTIMELORD"));
				TitleAPI.sendTitle(p, "§e§lTIMELORD");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("confuser")) {
			if (p.hasPermission("kit.confuser") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.CONFUSER);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lCONFUSER");
				p.getInventory().setItem(1, ItemUtils.item(Material.COAL, "§e§lCONFUSER"));
				TitleAPI.sendTitle(p, "§e§lCONFUSER");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("avatar")) {
			if (p.hasPermission("kit.avatar") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.AVATAR);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lAVATAR");
				p.getInventory().setItem(1, ItemUtils.item(Material.BEACON, "§e§lAVATAR"));
				TitleAPI.sendTitle(p, "§e§lAVATAR");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("C4")) {
			if (p.hasPermission("kit.C4") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.C4);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lC4");
				p.getInventory().setItem(1, ItemUtils.item(Material.SLIME_BALL, "§e§lC4"));
				TitleAPI.sendTitle(p, "§e§lC4");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("DeshFire")) {
			if (p.hasPermission("kit.deshfire") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.DESHFIRE);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lDESHFIRE");
				p.getInventory().setItem(1, ItemUtils.item(Material.REDSTONE_BLOCK, "§e§lDESHFIRE"));
				TitleAPI.sendTitle(p, "§e§lDESHFIRE");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("fisherman")) {
			if (p.hasPermission("kit.fisherman") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.FISHERMAN);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lFISHERMAN");
				p.getInventory().setItem(1, ItemUtils.item(Material.FISHING_ROD, "§e§lFISHERMAN"));
				TitleAPI.sendTitle(p, "§e§lFISHERMAN");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("gladiator")) {
			if (p.hasPermission("kit.gladiator") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.GLADIATOR);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lGLADIATOR");
				p.getInventory().setItem(1, ItemUtils.item(Material.IRON_FENCE, "§e§lGLADIATOR"));
				TitleAPI.sendTitle(p, "§e§lGLADIATOR");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("grappler")) {
			if (p.hasPermission("kit.grappler") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.GRAPPLER);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lGRAPPLER");
				p.getInventory().setItem(1, ItemUtils.item(Material.LEASH, "§e§lGRAPPLER"));
				TitleAPI.sendTitle(p, "§e§lGRAPPLER");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("hulk")) {
			if (p.hasPermission("kit.hulk") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lHULK");
				p.getInventory().setItem(1, ItemUtils.item(Material.SADDLE, "§e§lHULK"));
				TitleAPI.sendTitle(p, "§e§lHULK");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("jellyfish")) {
			if (p.hasPermission("kit.jellyfish") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.JELLYFISH);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lJELLYFISH");
				p.getInventory().setItem(1, ItemUtils.item(Material.CLAY_BALL, "§e§lJELLYFISH"));
				TitleAPI.sendTitle(p, "§e§lJELLYFISH");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("quickdropper")) {
			if (p.hasPermission("kit.quickdropper") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.QUICKDROPPER);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lQUICKDROPPER");
				TitleAPI.sendTitle(p, "§e§lQUICKDROPPER");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("kangaroo")) {
			if (p.hasPermission("kit.kangaroo") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.KANGAROO);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lKANGAROO");
				KitUtil.darItem(p, Material.FIREWORK, 1, "§e§lKANGAROO", 1);
				TitleAPI.sendTitle(p, "§e§lKANGAROO");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("magma")) {
			if (p.hasPermission("kit.magma") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.MAGMA);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lMAGMA");
				TitleAPI.sendTitle(p, "§e§lMAGMA");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("monk")) {
			if (p.hasPermission("kit.monk") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.MONK);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lMONK");
				p.getInventory().setItem(1, ItemUtils.item(Material.BLAZE_ROD, "§e§lMONK"));
				TitleAPI.sendTitle(p, "§e§lMONK");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("ninja")) {
			if (p.hasPermission("kit.ninja") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.NINJA);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lNINJA");
				TitleAPI.sendTitle(p, "§e§lNINJA");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("poseidon")) {
			if (p.hasPermission("kit.poseidon") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.POSEIDON);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lPOSEIDON");
				TitleAPI.sendTitle(p, "§e§lPOSEIDON");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("resouper")) {
			if (p.hasPermission("kit.resouper") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.RESOUPER);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lRESOUPER");
				TitleAPI.sendTitle(p, "§e§lRESOUPER");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("snail")) {
			if (p.hasPermission("kit.snail") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.SNAIL);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lSNAIL");
				TitleAPI.sendTitle(p, "§e§lSNAIL");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("sonic")) {
			if (p.hasPermission("kit.sonic") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.SONIC);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lSONIC");
				p.getInventory().setItem(1, ItemUtils.item(Material.LAPIS_BLOCK, "§e§lSONIC"));
				TitleAPI.sendTitle(p, "§e§lSONIC");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("archer")) {
			if (p.hasPermission("kit.archer") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.ARCHER);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lArcher");
				p.getInventory().setItem(1,
						ItemUtils.enchantedItem(Material.BOW, Enchantment.ARROW_INFINITE, 1, "§e§lARCHER"));
				p.getInventory().setItem(2, ItemUtils.item(Material.ARROW, "§cFLECHA"));
				TitleAPI.sendTitle(p, "§e§lARCHER");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("stomper")) {
			if (p.hasPermission("kit.stomper") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.STOMPER);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lSTOMPER");
				TitleAPI.sendTitle(p, "§e§lSTOMPER");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("switcher")) {
			if (p.hasPermission("kit.switcher") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.SWITCHER);
				KitUtil.darItem(p, Material.SNOW_BALL, 64, "§e§lSWITCHER", 1);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lSWITCHER");
				TitleAPI.sendTitle(p, "§e§lSWITCHER");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("swords")) {
			if (p.hasPermission("kit.swords") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.SWORDS);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lSWORDS");
				TitleAPI.sendTitle(p, "§e§lSWORDS");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("forcefield")) {
			if (p.hasPermission("kit.forcefield") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.FORCEFIELD);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lFORCEFIELD");
				p.getInventory().setItem(1, ItemUtils.item(Material.NETHER_FENCE, "§e§lFORCEFIELD"));
				TitleAPI.sendTitle(p, "§e§lFORCEFIELD");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("thor")) {
			if (p.hasPermission("kit.thor") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.THOR);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lTHOR");
				p.getInventory().setItem(1, ItemUtils.item(Material.GOLD_AXE, "§e§lTHOR"));
				TitleAPI.sendTitle(p, "§e§lTHOR");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("thresh")) {
			if (p.hasPermission("kit.thresh") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.THRESH);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lTHRESH");
				p.getInventory().setItem(1, ItemUtils.item(Material.LEVER, "§e§lTHRESH"));
				TitleAPI.sendTitle(p, "§e§lTHRESH");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("turtle")) {
			if (p.hasPermission("kit.turtle") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.TURTLE);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lTURTLE");
				TitleAPI.sendTitle(p, "§e§lTURTLE");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("viper")) {
			if (p.hasPermission("kit.viper") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.VIPER);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lVIPER");
				TitleAPI.sendTitle(p, "§e§lVIPER");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("viking")) {
			if (p.hasPermission("kit.Viking") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				KitUtil.darItem(p, Material.STONE_AXE, 1, "§e§lVIKING", 0);
				api.setKit(p, Kits.VIKING);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lVIKING");
				TitleAPI.sendTitle(p, "§e§lVIKING");
				SetArenaCommand.TeleportArenaRandom(p);
				api.setWarp(p, Warps.ARENA);
			}
		}
		if (args[0].equalsIgnoreCase("madman")) {
			if (p.hasPermission("kit.madman") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.MADMAN);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lMADMAN");
				TitleAPI.sendTitle(p, "§e§lMADMAN");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("specialist")) {
			if (p.hasPermission("kit.specialist") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.SPECIALIST);
				KitUtil.darItem(p, Material.ENCHANTED_BOOK, 1, "§e§lSPECIALIST", 1);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lSPECIALIST");
				TitleAPI.sendTitle(p, "§e§lSPECIALIST");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("hotpotato")) {
			if (p.hasPermission("kit.hotpotato") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.HOTPOTATO);
				KitUtil.darItem(p, Material.POTATO, 1, "§e§lHOTPOTATO", 1);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lHOTPOTATO");
				TitleAPI.sendTitle(p, "§e§lHOTPOTATO");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		if (args[0].equalsIgnoreCase("AntiTower")) {
			if (p.hasPermission("kit.antitower") || IniciarCommand.fullkit) {
				p.getInventory().clear();
				api.setKit(p, Kits.ANTITOWER);
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §7Você selecionou o Kit: §a§lAntiTower");
				TitleAPI.sendTitle(p, "§e§lANTI-TOWER");
				SetArenaCommand.TeleportArenaRandom(p);
			}
		}
		return false;
	}
}
