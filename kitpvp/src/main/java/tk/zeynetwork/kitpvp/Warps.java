package tk.zeynetwork.kitpvp;

import Zey.PvP.Warps.Evento;
import Zey.PvP.Warps.Fps;
import Zey.PvP.Warps.Lava;
import Zey.PvP.Warps.Parkour;
import Zey.PvP.Warps.Spawn;
import Zey.PvP.Warps.TheMain;
import tk.zeynetwork.kitpvp.api.Warp;
import tk.zeynetwork.kitpvp.warps.Arena;
import tk.zeynetwork.kitpvp.warps.Nenhuma;

public class Warps {
	public static final Warp 
			ARENA = new Arena(),
			CHALLENGE = new Lava(),
			EVENTO = new Evento(),
			FPS = new Fps(),
			MAIN = new TheMain(),
			NENHUMA = new Nenhuma(),
			PARKOUR = new Parkour(),
			SPAWN = new Spawn();
}