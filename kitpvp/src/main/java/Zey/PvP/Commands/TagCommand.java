package Zey.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.APIs.TagsAPI;
import Zey.PvP.Main.Main;
import ca.wacos.nametagedit.NametagAPI;
import tk.zeynetwork.utils.ChatUtils;

public class TagCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(String.valueOf(Main.PREFIX) + " §7» §cApenas jogadores podem usar isso.");
			return true;
		}
		Player p = (Player) sender;
		if (args.length == 0) {
			if (p.getName().equalsIgnoreCase("Neewaska_") || p.getName().equalsIgnoreCase("OwCry")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§4[DONA]", "§e(Clique) §7" + "§7Exemplo: §4[DONA] §7" + p.getName(), "/tag dona");
				ChatUtils.runCommand(p, "§4[SUB-DONA]", "§e(Clique) §7Exemplo: §4[SUB-DONA] §7" + p.getName(), "/tag subdona");
				ChatUtils.runCommand(p, "§3[DEVELOPER]", "§e(Clique) §7Exemplo: §3[DEVELOPER] §7" + p.getName(), "/tag developer");
				ChatUtils.runCommand(p, "§c[GERENTE]", "§e(Clique) §7Exemplo: §c[GERENTE] §7" + p.getName(), "/tag gerente");
				ChatUtils.runCommand(p, "§c[ADMIN]", "§e(Clique) §7Exemplo: §c[ADMIN] §7" + p.getName(), "/tag admin");
				ChatUtils.runCommand(p, "§5[MOD]", "§e(Clique) §7Exemplo: §5[MOD] §7" + p.getName(), "/tag mod");
				ChatUtils.runCommand(p, "§d[TRIAL]", "§e(Clique) §7Exemplo: §d[TRIAL] §7" + p.getName(), "/tag trial");
				ChatUtils.runCommand(p, "§d[HELPER]", "§e(Clique) §7Exemplo: §d[HELPER] §7" + p.getName(), "/tag helper");
				ChatUtils.runCommand(p, "§2[BUILDER]", "§e(Clique) §7Exemplo: §2[BUILDER] §7" + p.getName(), "/tag builder");
				ChatUtils.runCommand(p, "§b[YOUTUBER]", "§e(Clique) §7Exemplo: §b[YOUTUBER] §7" + p.getName(), "/tag youtuber");
				ChatUtils.runCommand(p, "§a[FRIEND]", "§e(Clique) §7Exemplo: §a[FRIEND] §7" + p.getName(), "/tag friend");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.dono")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§4[DONO]", "§e(Clique) §7Exemplo: §4[DONO] §7" + p.getName(), "/tag dono");
				ChatUtils.runCommand(p, "§4[SUB-DONO]", "§e(Clique) §7Exemplo: §4[SUB-DONO] §7" + p.getName(), "/tag subdono");
				ChatUtils.runCommand(p, "§3[DEVELOPER]", "§e(Clique) §7Exemplo: §3[DEVELOPER] §7" + p.getName(), "/tag developer");
				ChatUtils.runCommand(p, "§c[GERENTE]", "§e(Clique) §7Exemplo: §c[GERENTE] §7" + p.getName(), "/tag gerente");
				ChatUtils.runCommand(p, "§c[ADMIN]", "§e(Clique) §7Exemplo: §c[ADMIN] §7" + p.getName(), "/tag admin");
				ChatUtils.runCommand(p, "§5[MOD]", "§e(Clique) §7Exemplo: §5[MOD] §7" + p.getName(), "/tag mod");
				ChatUtils.runCommand(p, "§d[TRIAL]", "§e(Clique) §7Exemplo: §d[TRIAL] §7" + p.getName(), "/tag trial");
				ChatUtils.runCommand(p, "§d[HELPER]", "§e(Clique) §7Exemplo: §d[HELPER] §7" + p.getName(), "/tag helper");
				ChatUtils.runCommand(p, "§2[BUILDER]", "§e(Clique) §7Exemplo: §2[BUILDER] §7" + p.getName(), "/tag builder");
				ChatUtils.runCommand(p, "§b[YOUTUBER]", "§e(Clique) §7Exemplo: §b[YOUTUBER] §7" + p.getName(), "/tag youtuber");
				ChatUtils.runCommand(p, "§a[FRIEND]", "§e(Clique) §7Exemplo: §a[FRIEND] §7" + p.getName(), "/tag friend");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.dona")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§4[DONA]", "§e(Clique) §7" + "§7Exemplo: §4[DONA] §7" + p.getName(), "§e(Clique) §7" + "§7Exemplo: §4[DONA] §7" + p.getName());
				ChatUtils.runCommand(p, "§4[SUB-DONA]", "§e(Clique) §7Exemplo: §4[SUB-DONA] §7" + p.getName(), "§e(Clique) §7" + "§7Exemplo: §4[SUB-DONA] §7" + p.getName());
				ChatUtils.runCommand(p, "§3[DEVELOPER]", "§e(Clique) §7Exemplo: §3[DEVELOPER] §7" + p.getName(), "/tag developer");
				ChatUtils.runCommand(p, "§c[GERENTE]", "§e(Clique) §7Exemplo: §c[GERENTE] §7" + p.getName(), "/tag gerente");
				ChatUtils.runCommand(p, "§c[ADMIN]", "§e(Clique) §7Exemplo: §c[ADMIN] §7" + p.getName(), "/tag admin");
				ChatUtils.runCommand(p, "§5[MOD]", "§e(Clique) §7Exemplo: §5[MOD] §7" + p.getName(), "/tag mod");
				ChatUtils.runCommand(p, "§d[TRIAL]", "§e(Clique) §7Exemplo: §d[TRIAL] §7" + p.getName(), "/tag trial");
				ChatUtils.runCommand(p, "§d[HELPER]", "§e(Clique) §7Exemplo: §d[HELPER] §7" + p.getName(), "/tag helper");
				ChatUtils.runCommand(p, "§2[BUILDER]", "§e(Clique) §7Exemplo: §2[BUILDER] §7" + p.getName(), "/tag builder");
				ChatUtils.runCommand(p, "§b[YOUTUBER]", "§e(Clique) §7Exemplo: §b[YOUTUBER] §7" + p.getName(), "/tag youtuber");
				ChatUtils.runCommand(p, "§a[FRIEND]", "§e(Clique) §7Exemplo: §a[FRIEND] §7" + p.getName(), "/tag friend");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.subdono")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§4[SUB-DONO]", "§e(Clique) §7Exemplo: §4[SUB-DONO] §7" + p.getName(), "/tag subdono");
				ChatUtils.runCommand(p, "§c[GERENTE]", "§e(Clique) §7Exemplo: §c[GERENTE] §7" + p.getName(), "/tag gerente");
				ChatUtils.runCommand(p, "§c[ADMIN]", "§e(Clique) §7Exemplo: §c[ADMIN] §7" + p.getName(), "/tag admin");
				ChatUtils.runCommand(p, "§5[MOD]", "§e(Clique) §7Exemplo: §5[MOD] §7" + p.getName(), "/tag mod");
				ChatUtils.runCommand(p, "§d[TRIAL]", "§e(Clique) §7Exemplo: §d[TRIAL] §7" + p.getName(), "/tag trial");
				ChatUtils.runCommand(p, "§d[HELPER]", "§e(Clique) §7Exemplo: §d[HELPER] §7" + p.getName(), "/tag helper");
				ChatUtils.runCommand(p, "§2[BUILDER]", "§e(Clique) §7Exemplo: §2[BUILDER] §7" + p.getName(), "/tag builder");
				ChatUtils.runCommand(p, "§b[YOUTUBER]", "§e(Clique) §7Exemplo: §b[YOUTUBER] §7" + p.getName(), "/tag youtuber");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.subdona")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§4[SUB-DONA]", "§e(Clique) §7Exemplo: §4[SUB-DONA] §7" + p.getName(), "§e(Clique) §7" + "§7Exemplo: §4[SUB-DONA] §7" + p.getName());
				ChatUtils.runCommand(p, "§c[GERENTE]", "§e(Clique) §7Exemplo: §c[GERENTE] §7" + p.getName(), "/tag gerente");
				ChatUtils.runCommand(p, "§c[ADMIN]", "§e(Clique) §7Exemplo: §c[ADMIN] §7" + p.getName(), "/tag admin");
				ChatUtils.runCommand(p, "§5[MOD]", "§e(Clique) §7Exemplo: §5[MOD] §7" + p.getName(), "/tag mod");
				ChatUtils.runCommand(p, "§d[TRIAL]", "§e(Clique) §7Exemplo: §d[TRIAL] §7" + p.getName(), "/tag trial");
				ChatUtils.runCommand(p, "§d[HELPER]", "§e(Clique) §7Exemplo: §d[HELPER] §7" + p.getName(), "/tag helper");
				ChatUtils.runCommand(p, "§2[BUILDER]", "§e(Clique) §7Exemplo: §2[BUILDER] §7" + p.getName(), "/tag builder");
				ChatUtils.runCommand(p, "§b[YOUTUBER]", "§e(Clique) §7Exemplo: §b[YOUTUBER] §7" + p.getName(), "/tag youtuber");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.developer")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§3[DEVELOPER]", "§e(Clique) §7Exemplo: §3[DEVELOPER] §7" + p.getName(), "/tag developer");
				ChatUtils.runCommand(p, "§4[DONA]", "§e(Clique) §7" + "§7Exemplo: §4[DONA] §7" + p.getName(), "§e(Clique) §7" + "§7Exemplo: §4[DONA] §7" + p.getName());
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§4[SUB-DONA]", "§e(Clique) §7Exemplo: §4[SUB-DONA] §7" + p.getName(), "§e(Clique) §7" + "§7Exemplo: §4[SUB-DONA] §7" + p.getName());
				ChatUtils.runCommand(p, "§3[DEVELOPER]", "§e(Clique) §7Exemplo: §3[DEVELOPER] §7" + p.getName(), "/tag developer");
				ChatUtils.runCommand(p, "§c[GERENTE]", "§e(Clique) §7Exemplo: §c[GERENTE] §7" + p.getName(), "/tag gerente");
				ChatUtils.runCommand(p, "§c[ADMIN]", "§e(Clique) §7Exemplo: §c[ADMIN] §7" + p.getName(), "/tag admin");
				ChatUtils.runCommand(p, "§5[MOD]", "§e(Clique) §7Exemplo: §5[MOD] §7" + p.getName(), "/tag mod");
				ChatUtils.runCommand(p, "§d[TRIAL]", "§e(Clique) §7Exemplo: §d[TRIAL] §7" + p.getName(), "/tag trial");
				ChatUtils.runCommand(p, "§d[HELPER]", "§e(Clique) §7Exemplo: §d[HELPER] §7" + p.getName(), "/tag helper");
				ChatUtils.runCommand(p, "§2[BUILDER]", "§e(Clique) §7Exemplo: §2[BUILDER] §7" + p.getName(), "/tag builder");
				ChatUtils.runCommand(p, "§b[YOUTUBER]", "§e(Clique) §7Exemplo: §b[YOUTUBER] §7" + p.getName(), "/tag youtuber");
				ChatUtils.runCommand(p, "§a[FRIEND]", "§e(Clique) §7Exemplo: §a[FRIEND] §7" + p.getName(), "/tag friend");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.gerente")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§c[GERENTE]", "§e(Clique) §7Exemplo: §c[GERENTE] §7" + p.getName(), "/tag gerente");
				ChatUtils.runCommand(p, "§c[ADMIN]", "§e(Clique) §7Exemplo: §c[ADMIN] §7" + p.getName(), "/tag admin");
				ChatUtils.runCommand(p, "§5[MOD]", "§e(Clique) §7Exemplo: §5[MOD] §7" + p.getName(), "/tag mod");
				ChatUtils.runCommand(p, "§d[TRIAL]", "§e(Clique) §7Exemplo: §d[TRIAL] §7" + p.getName(), "/tag trial");
				ChatUtils.runCommand(p, "§d[HELPER]", "§e(Clique) §7Exemplo: §d[HELPER] §7" + p.getName(), "/tag helper");
				ChatUtils.runCommand(p, "§2[BUILDER]", "§e(Clique) §7Exemplo: §2[BUILDER] §7" + p.getName(), "/tag builder");
				ChatUtils.runCommand(p, "§b[YOUTUBER]", "§e(Clique) §7Exemplo: §b[YOUTUBER] §7" + p.getName(), "/tag youtuber");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.admin")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§c[ADMIN]", "§e(Clique) §7Exemplo: §c[ADMIN] §7" + p.getName(), "/tag admin");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.mod")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§5[MOD]", "§e(Clique) §7Exemplo: §5[MOD] §7" + p.getName(), "/tag mod");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.trial")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§d[TRIAL]", "§e(Clique) §7Exemplo: §d[TRIAL] §7" + p.getName(), "/tag trial");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.helper")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§d[HELPER]", "§e(Clique) §7Exemplo: §d[HELPER] §7" + p.getName(), "/tag helper");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.builder")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§2[BUILDER]", "§e(Clique) §7Exemplo: §2[BUILDER] §7" + p.getName(), "/tag builder");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.youtuber")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§b[YOUTUBER]", "§e(Clique) §7Exemplo: §b[YOUTUBER] §7" + p.getName(), "/tag youtuber");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.friend")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§a[FRIEND]", "§e(Clique) §7Exemplo: §a[FRIEND] §7" + p.getName(), "/tag friend");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.beta")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§1[BETA]", "§e(Clique) §7Exemplo: §1[BETA] §7" + p.getName(), "/tag beta");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.supremo")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§e[SUPREMO]", "§e(Clique) §7Exemplo: §e[SUPREMO] §7" + p.getName(), "/tag supremo");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.pro")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§6[PRO]", "§e(Clique) §7Exemplo: §6[PRO] §7" + p.getName(), "/tag pro");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.mvp")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§9[MVP]", "§e(Clique) §7Exemplo: §9[MVP] §7" + p.getName(), "/tag mvp");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			if (p.hasPermission("grupo.vip")) {
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
				p.sendMessage("§E");
				ChatUtils.runCommand(p, "§a[VIP]", "§e(Clique) §7Exemplo: §a[VIP] §7" + p.getName(), "/tag vip");
				ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
				return true;
			}
			p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aLista de §fTODAS§a as §fTAGS§a disponiveis para você:");
			p.sendMessage("§E");
			ChatUtils.runCommand(p, "§7[NORMAL]", "§e(Clique) §7Exemplo: §7[NORMAL] §7" + p.getName(), "/tag normal");
			return true;
		}
		if (p.getName().equalsIgnoreCase("OwCry")) {
			if (args[0].equalsIgnoreCase("dona")) {
				TagsAPI.setarTag(p, "§4[DONA]§7 ");
				NametagAPI.setPrefix(p.getName(), "§4[DONA]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §4[DONA]");

				return true;
			}
		}
		if (p.getName().equalsIgnoreCase("Neewaska_")) {
			if (args[0].equalsIgnoreCase("dona")) {
				TagsAPI.setarTag(p, "§4[DONA]§7 ");
				NametagAPI.setPrefix(p.getName(), "§4[DONA]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §4[DONA]");

				return true;
			}
		}
		if (p.hasPermission("tag.dono")) {
			if (args[0].equalsIgnoreCase("dono")) {
				TagsAPI.setarTag(p, "§4[DONO]§7 ");
				NametagAPI.setPrefix(p.getName(), "§4[DONO]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §4[DONO]");

				return true;
			}
		}
		if (p.hasPermission("tag.dona")) {
			if (args[0].equalsIgnoreCase("dona")) {
				TagsAPI.setarTag(p, "§4[DONA]§7 ");
				NametagAPI.setPrefix(p.getName(), "§4[DONA]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §4[DONA]");

				return true;
			}
		}
		if (p.hasPermission("tag.subdono")) {
			if (args[0].equalsIgnoreCase("subdono")) {
				TagsAPI.setarTag(p, "§4[SUB-DONO]§7 ");
				NametagAPI.setPrefix(p.getName(), "§4[SUB-DONO]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §4[SUB-DONO]");

				return true;
			}
		}
		if (p.hasPermission("tag.subdona")) {
			if (args[0].equalsIgnoreCase("subdona")) {
				TagsAPI.setarTag(p, "§4[SUB-DONA]§7 ");
				NametagAPI.setPrefix(p.getName(), "§4[SUB-DONA]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §4[SUB-DONA]");

				return true;
			}
		}
		if (p.hasPermission("tag.developer")) {
			if (args[0].equalsIgnoreCase("developer")) {
				TagsAPI.setarTag(p, "§3[DEVELOPER]§7 ");
				NametagAPI.setPrefix(p.getName(), "§3[DEVELOPER]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §3[DEVELOPER]");

				return true;
			}
		}
		if (p.hasPermission("tag.gerente")) {
			if (args[0].equalsIgnoreCase("gerente")) {
				TagsAPI.setarTag(p, "§c[GERENTE]§7 ");
				NametagAPI.setPrefix(p.getName(), "§c[GERENTE]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §c[GERENTE]");

				return true;
			}
		}
		if (p.hasPermission("tag.admin")) {
			if (args[0].equalsIgnoreCase("admin")) {
				TagsAPI.setarTag(p, "§c[ADMIN]§7 ");
				NametagAPI.setPrefix(p.getName(), "§c[ADMIN]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §c[ADMIN]");

				return true;
			}
		}
		if (p.hasPermission("tag.mod")) {
			if (args[0].equalsIgnoreCase("mod")) {
				TagsAPI.setarTag(p, "§5[MOD]§7 ");
				NametagAPI.setPrefix(p.getName(), "§5[MOD]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §5[MOD]");

				return true;
			}
		}
		if (p.hasPermission("tag.trial")) {
			if (args[0].equalsIgnoreCase("trial")) {
				TagsAPI.setarTag(p, "§d[TRIAL]§7 ");
				NametagAPI.setPrefix(p.getName(), "§d[TRIAL]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §d[TRIAL]");

				return true;
			}
		}
		if (p.hasPermission("tag.helper")) {
			if (args[0].equalsIgnoreCase("helper")) {
				TagsAPI.setarTag(p, "§d[HELPER]§7 ");
				NametagAPI.setPrefix(p.getName(), "§d[HELPER]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §d[HELPER]");

				return true;
			}
		}
		if (p.hasPermission("tag.builder")) {
			if (args[0].equalsIgnoreCase("builder")) {
				TagsAPI.setarTag(p, "§2[BUILDER]§7 ");
				NametagAPI.setPrefix(p.getName(), "§2[BUILDER]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §2[BUILDER]");

				return true;
			}
		}
		if (p.hasPermission("tag.youtuber")) {
			if (args[0].equalsIgnoreCase("youtuber")) {
				TagsAPI.setarTag(p, "§b[YOUTUBER]§7 ");
				NametagAPI.setPrefix(p.getName(), "§b[YOUTUBER]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §B[YOUTUBER]");

				return true;
			}
		}
		if (p.hasPermission("tag.friend")) {
			if (args[0].equalsIgnoreCase("friend")) {
				TagsAPI.setarTag(p, "§a[FRIEND]§7 ");
				NametagAPI.setPrefix(p.getName(), "§a[FRIEND]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §a[FRIEND]");

				return true;
			}
		}
		if (p.hasPermission("tag.beta")) {
			if (args[0].equalsIgnoreCase("beta")) {
				TagsAPI.setarTag(p, "§1[BETA]§7 ");
				NametagAPI.setPrefix(p.getName(), "§1[BETA]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §1[BETA]");

				return true;
			}
		}
		if (p.hasPermission("tag.supremo")) {
			if (args[0].equalsIgnoreCase("supremo")) {
				TagsAPI.setarTag(p, "§e[SUPREMO]§7 ");
				NametagAPI.setPrefix(p.getName(), "§e[SUPREMO]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §e[SUPREMO]");

				return true;
			}
		}
		if (p.hasPermission("tag.pro")) {
			if (args[0].equalsIgnoreCase("pro")) {
				TagsAPI.setarTag(p, "§6[PRO]§7 ");
				NametagAPI.setPrefix(p.getName(), "§6[PRO]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §6[PRO]§7");

				return true;
			}
		}
		if (p.hasPermission("tag.mvp")) {
			if (args[0].equalsIgnoreCase("mvp")) {
				TagsAPI.setarTag(p, "§9[MVP]§7 ");
				NametagAPI.setPrefix(p.getName(), "§9[MVP]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §9[MVP]§7");

				return true;
			}
		}
		if (p.hasPermission("tag.vip")) {
			if (args[0].equalsIgnoreCase("vip")) {
				TagsAPI.setarTag(p, "§a[VIP]§7 ");
				NametagAPI.setPrefix(p.getName(), "§a[VIP]§7 ");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §a[VIP]§7");

				return true;
			}
		}
		if (p.hasPermission("tag.normal")) {
			if (args[0].equalsIgnoreCase("normal")) {
				TagsAPI.setarTag(p, "§7");
				NametagAPI.setPrefix(p.getName(), "§7");
				p.sendMessage(String.valueOf(Main.PREFIX) + " §7» §aSua TAG foi alterada para §7[NORMAL]");

				return true;
			}
		}
		return false;
	}
}
