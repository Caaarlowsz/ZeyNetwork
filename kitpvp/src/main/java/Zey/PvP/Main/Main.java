package Zey.PvP.Main;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import Zey.PvP.Commands.AdminCommand;
import Zey.PvP.Commands.AplicarCommand;
import Zey.PvP.Commands.AutoSoupCommand;
import Zey.PvP.Commands.BroadcastCommand;
import Zey.PvP.Commands.BuildCommand;
import Zey.PvP.Commands.CageCommand;
import Zey.PvP.Commands.CcCommand;
import Zey.PvP.Commands.ChatCommand;
import Zey.PvP.Commands.DarCoinsCommand;
import Zey.PvP.Commands.FinalizarCommand;
import Zey.PvP.Commands.FlyCommand;
import Zey.PvP.Commands.GmCommand;
import Zey.PvP.Commands.HeadCommand;
import Zey.PvP.Commands.InfoCommand;
import Zey.PvP.Commands.IniciarCommand;
import Zey.PvP.Commands.InvCommand;
import Zey.PvP.Commands.KitCommand;
import Zey.PvP.Commands.LigaCommand;
import Zey.PvP.Commands.LimparTelaCommand;
import Zey.PvP.Commands.MacroTestCommand;
import Zey.PvP.Commands.PingCommand;
import Zey.PvP.Commands.PvPCommand;
import Zey.PvP.Commands.RecraftCommand;
import Zey.PvP.Commands.ReportCommand;
import Zey.PvP.Commands.ScoreCommand;
import Zey.PvP.Commands.SetArenaCommand;
import Zey.PvP.Commands.SetGroupCommand;
import Zey.PvP.Commands.SetVipCommand;
import Zey.PvP.Commands.SortearKit;
import Zey.PvP.Commands.SortearVip;
import Zey.PvP.Commands.TagCommand;
import Zey.PvP.Commands.TellCommand;
import Zey.PvP.Commands.TpAllCommand;
import Zey.PvP.Commands.TpCommand;
import Zey.PvP.Commands.TpHereCommand;
import Zey.PvP.Commands.Vis;
import Zey.PvP.Commands.sKit;
import Zey.PvP.Config.MyConfigManager;
import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Menus.MenuLojaExtras;
import Zey.PvP.Menus.MenuLojaKits;
import Zey.PvP.Score.SManager;
import Zey.PvP.Warps.Evento;
import Zey.PvP.Warps.Fps;
import Zey.PvP.Warps.Lava;
import Zey.PvP.Warps.Parkour;
import Zey.PvP.Warps.SetEvento;
import Zey.PvP.Warps.SetFps;
import Zey.PvP.Warps.SetLava;
import Zey.PvP.Warps.SetParkour;
import Zey.PvP.Warps.SetSpawn;
import Zey.PvP.Warps.SetarRdm;
import Zey.PvP.Warps.Setthemain;
import Zey.PvP.Warps.Spawn;
import Zey.PvP.Warps.TheMain;
import Zey.PvP.Warps.WarpRdm;
import net.minecraft.util.com.google.common.collect.Lists;
import tk.zeynetwork.utils.ClassGetter;

public final class Main extends JavaPlugin {

	public static String prefix;
	public static String loja;
	public static String ts;
	public static String discord;
	public static String motd;
	public static String motd2;
	public static Plugin plugin;
	public static Main instance;
	public static MyConfigManager manager;

	public static List<String> admins = Lists.newArrayList();

	public static Main getInstace() {
		return instance;
	}

	public static Main getInstance1() {
		return instance;
	}

	public static Main getPlugin() {
		return (Main) JavaPlugin.getProvidingPlugin((Class<?>) Main.class);
	}

	@SuppressWarnings("deprecation")
	public void onEnable() {
		for (Player todos : Bukkit.getOnlinePlayers()) {
			todos.kickPlayer(
					"§6§lZey§f§lNetwork \n \n §cServidor Reiniciando \n Para sua segurança e a de outros jogadores(a), você foi kickado. \n\nAguarde o servidor reiniciar e entre para jogar novamente =)");
		}
		SManager.onEnable();
		try {
			saveDefaultConfig();
		} catch (Exception localException) {
		}
		prefix = ("§6§lZey§f§lPvP");
		motd = ("§6§lZey§f§lNetwork §7(1.7, 1.8) \n§e§lServidor, ZeyPvP - 1.");
		motd2 = ("§6§lZey§f§lNetwork §7(1.7, 1.8) \n§c§lServidor em manutenção.");

		new ClassGetter(this, "Zey.PvP").registerListeners();
		Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
		Bukkit.getConsoleSender().sendMessage("          §6§lZey§f§lNetwork        ");
		Bukkit.getConsoleSender().sendMessage("                                       ");
		Bukkit.getConsoleSender().sendMessage("      §6§lZey§f§lPvP §a§lHABILITADO");
		Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");

		getConfig().options().copyDefaults(true);
		getConfig().options().copyHeader(true);
		saveConfig();
		manager = new MyConfigManager(this);
		ZeyCoins.loadMoneyManager();

		instance = this;
		plugin = this;
		Comandos();
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
		Bukkit.getConsoleSender().sendMessage("          §6§lZey§f§lNetwork        ");
		Bukkit.getConsoleSender().sendMessage("                                       ");
		Bukkit.getConsoleSender().sendMessage("      §6§lZey§f§lPvP §c§lDESABILITADO!");
		Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
	}

	void Comandos() {
		getCommand("admin").setExecutor(new AdminCommand(this));
		getCommand("autosoup").setExecutor(new AutoSoupCommand(this));
		getCommand("bc").setExecutor(new BroadcastCommand());
		getCommand("build").setExecutor(new BuildCommand());
		getCommand("cage").setExecutor(new CageCommand());
		getCommand("cc").setExecutor(new CcCommand(this));
		getCommand("chat").setExecutor(new ChatCommand());
		getCommand("darcoins").setExecutor(new DarCoinsCommand());
		getCommand("finalizar").setExecutor(new FinalizarCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("gm").setExecutor(new GmCommand(this));
		getCommand("head").setExecutor(new HeadCommand());
		getCommand("iniciar").setExecutor(new IniciarCommand());
		getCommand("inv").setExecutor(new InvCommand());
		getCommand("kit").setExecutor(new KitCommand(this));
		getCommand("liga").setExecutor(new LigaCommand());
		getCommand("testmacro").setExecutor(new MacroTestCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("pvp").setExecutor(new PvPCommand());
		getCommand("score").setExecutor(new ScoreCommand());
		getCommand("setarena").setExecutor(new SetArenaCommand(this));
		getCommand("setgroup").setExecutor(new SetGroupCommand());
		getCommand("setvip").setExecutor(new SetVipCommand());
		getCommand("skit").setExecutor(new sKit(this));
		getCommand("sortearkit").setExecutor(new SortearKit());
		getCommand("sortearvip").setExecutor(new SortearVip());
		getCommand("tag").setExecutor(new TagCommand());
		getCommand("tpall").setExecutor(new TpAllCommand());
		getCommand("tp").setExecutor(new TpCommand());
		getCommand("tphere").setExecutor(new TpHereCommand());
		getCommand("vis").setExecutor(new Vis());
		getCommand("limpartela").setExecutor(new LimparTelaCommand());
		getCommand("recraft").setExecutor(new RecraftCommand());
		getCommand("tell").setExecutor(new TellCommand());
		getCommand("aplicar").setExecutor(new AplicarCommand());
		getCommand("ajuda").setExecutor(new InfoCommand());
		getCommand("report").setExecutor(new ReportCommand(this));
		getCommand("fps").setExecutor(new Fps(this));
		getCommand("challenge").setExecutor(new Lava(this));
		getCommand("evento").setExecutor(new Evento(this));
		getCommand("parkour").setExecutor(new Parkour(this));
		getCommand("rdmset").setExecutor(new SetarRdm(this));
		getCommand("fpsset").setExecutor(new SetFps(this));
		getCommand("challengeset").setExecutor(new SetLava(this));
		getCommand("eventoset").setExecutor(new SetEvento(this));
		getCommand("parkourset").setExecutor(new SetParkour(this));
		getCommand("mainset").setExecutor(new Setthemain(this));
		getCommand("spawnset").setExecutor(new SetSpawn(this));
		getCommand("main").setExecutor(new TheMain(this));
		getCommand("spawn").setExecutor(new Spawn(this));
		getCommand("lojakits").setExecutor(new MenuLojaKits());
		getCommand("rdm").setExecutor(new WarpRdm(this));
		getCommand("lojaextras").setExecutor(new MenuLojaExtras());
	}
}