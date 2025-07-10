package tk.zeynetwork.kitpvp;

import Zey.PvP.Warps.Evento;
import Zey.PvP.Warps.Fps;
import Zey.PvP.Warps.Lava;
import Zey.PvP.Warps.Parkour;
import Zey.PvP.Warps.Spawn;
import Zey.PvP.Warps.TheMain;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.kitpvp.api.Warp;
import tk.zeynetwork.kitpvp.warps.Arena;
import tk.zeynetwork.kitpvp.warps.Nenhuma;

public class Warps {
	public static final Warp 
	NENHUMA = new Nenhuma(), 
	SPAWN = new Spawn(),
	ARENA = new Arena(), 
	CHALLENGE = new Lava(), 
	EVENTO = new Evento(), 
	FPS = new Fps(),
	MAIN = new TheMain(), 
	PARKOUR = new Parkour(); 

	public static void loadWarps() {
		KitPvPAPI.addWarp(Warps.NENHUMA);
		KitPvPAPI.addWarp(Warps.SPAWN);
		KitPvPAPI.addWarp(Warps.ARENA);
		KitPvPAPI.addWarp(Warps.CHALLENGE);
		KitPvPAPI.addWarp(Warps.EVENTO);
		KitPvPAPI.addWarp(Warps.FPS);
		KitPvPAPI.addWarp(Warps.MAIN);
		KitPvPAPI.addWarp(Warps.PARKOUR);
	}
}