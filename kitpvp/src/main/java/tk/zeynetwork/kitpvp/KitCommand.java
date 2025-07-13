package tk.zeynetwork.kitpvp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Commands.IniciarCommand;
import Zey.PvP.Commands.SetArenaCommand;
import Zey.PvP.Main.Main;
import Zey.PvP.Utils.Proteção;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvP;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.TitleAPI;

public final class KitCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!label.equalsIgnoreCase("kit"))
			return false;
		if (!(sender instanceof Player))
			return false;

		Player player = (Player) sender;
		if (args.length == 0) {
			player.sendMessage(Main.PREFIX + " §cErrado, utilize a sintaxe correta: /kit (kit)");
			return true;
		}
		if (Main.admins.contains(player.getName())) {
			player.sendMessage(Main.PREFIX + " §cNo momento, você está no /admin. Para pegar um kit, volte ao spawn usando o comando: /spawn");
			return true;
		}

		KitPvP api = KitPvPAPI.getInstance();
		if (api.hasKit(player)) {
			player.sendMessage(Main.PREFIX + "§cVocê já está utilizando um Kit. Para pegar outro, volte ao spawn usando o comando: /spawn");
			return true;
		}
		if (!api.getWarp(player).equals(Warps.SPAWN)) {
			player.sendMessage(Main.PREFIX + "§cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
			return true;
		}

		Kit kit = api.getKit(args[0]);
		if (kit == null || kit.equals(Kits.NENHUM))
			return false;
		if (kit.equals(Kits.PVP) || player.hasPermission("kit." + kit.getName()) || IniciarCommand.fullkit) {
			Proteção.setImortal(player, false);
			api.setKit(player, kit);
			player.sendMessage(Main.PREFIX + " §7Você selecionou o Kit: §a§l" + kit.getName().toUpperCase());
			TitleAPI.sendTitle(player, "§e§l" + kit.getName().toUpperCase());
			SetArenaCommand.TeleportArenaRandom(player);
			return true;
		}
		return false;
	}
}