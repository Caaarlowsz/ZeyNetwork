package Zey.PvP.Main;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
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
import tk.zeynetwork.kitpvp.Warps;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.utils.ClassGetter;
import tk.zeynetwork.utils.ConfigUtils;

public final class Main extends JavaPlugin {

	public static final String PREFIX = "§6§lZey§f§lPvP",
			MOTD = "§6§lZey§f§lNetwork §7(1.7, 1.8) \n§e§lServidor, ZeyPvP - 1.",
			WHITELIST_MOTD = "§6§lZey§f§lNetwork §7(1.7, 1.8) \n§c§lServidor em manutenção.";
	public static MyConfigManager manager;

	public static List<String> admins = Lists.newArrayList();

	private static KitPvPAPI api;

	public static KitPvPAPI getAPI() {
		return api;
	}

	public static Main getPlugin() {
		return getPlugin(Main.class);
	}

	public void onEnable() {
		SManager.onEnable();

		api = new KitPvPAPI(this);
		getAPI().addWarp(Warps.ARENA);
		getAPI().addWarp(Warps.CHALLENGE);
		getAPI().addWarp(Warps.EVENTO);
		getAPI().addWarp(Warps.FPS);
		getAPI().addWarp(Warps.MAIN);
		getAPI().addWarp(Warps.NENHUMA);
		getAPI().addWarp(Warps.PARKOUR);
		getAPI().addWarp(Warps.SPAWN);

		ConfigUtils.setupDefaultConfig(this);
		ClassGetter.registerListeners(this, "Zey.PvP");
		this.logPluginStatus(true);

		manager = new MyConfigManager(this);
		ZeyCoins.loadMoneyManager();

		Comandos();
	}

	public void onDisable() {
		StringBuilder kick = new StringBuilder("§6§lZey§f§lNetwork ");
		kick.append("\n \n §cServidor Reiniciando ");
		kick.append("\n Para sua segurança e a de outros jogadores(a), você foi kickado. ");
		kick.append("\n\nAguarde o servidor reiniciar e entre para jogar novamente =)");
		for (Player players : Bukkit.getOnlinePlayers())
			players.kickPlayer(kick.toString());
		Bukkit.getScheduler().cancelTasks(this);
		HandlerList.unregisterAll(this);
		this.logPluginStatus(false);
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
		getCommand("fps").setExecutor(new Fps());
		getCommand("challenge").setExecutor(new Lava());
		getCommand("evento").setExecutor(new Evento());
		getCommand("parkour").setExecutor(new Parkour());
		getCommand("rdmset").setExecutor(new SetarRdm(this));
		getCommand("fpsset").setExecutor(new SetFps(this));
		getCommand("challengeset").setExecutor(new SetLava(this));
		getCommand("eventoset").setExecutor(new SetEvento(this));
		getCommand("parkourset").setExecutor(new SetParkour(this));
		getCommand("mainset").setExecutor(new Setthemain(this));
		getCommand("spawnset").setExecutor(new SetSpawn(this));
		getCommand("main").setExecutor(new TheMain());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("lojakits").setExecutor(new MenuLojaKits());
		getCommand("rdm").setExecutor(new WarpRdm(this));
		getCommand("lojaextras").setExecutor(new MenuLojaExtras());
	}

	private void logPluginStatus(boolean enabled) {
		StringBuilder msg = new StringBuilder();
		msg.append("§b§l§m-------------------------------------");
		msg.append("\n          §6§lZey§f§lNetwork        ");
		msg.append("\n                                       ");
		msg.append("\n      §6§lZey§f§lPvP " + (enabled ? "§a§lHABILITADO" : "§c§lDESABILITADO!"));
		msg.append("\n§b§l§m-------------------------------------");
		for (String s : msg.toString().split("\n"))
			Bukkit.getConsoleSender().sendMessage(s);
	}
}