package tk.zeynetwork.kitpvp;

import Zey.PvP.Kits.Ajnin;
import Zey.PvP.Kits.Armor;
import Zey.PvP.Kits.Avatar;
import Zey.PvP.Kits.Confuser;
import Zey.PvP.Kits.DeshFire;
import Zey.PvP.Kits.Fisherman;
import Zey.PvP.Kits.Gladiator;
import Zey.PvP.Kits.Grappler;
import Zey.PvP.Kits.HotPotato;
import Zey.PvP.Kits.Hulk;
import Zey.PvP.Kits.JellyFish;
import Zey.PvP.Kits.Kangaroo;
import Zey.PvP.Kits.Madman;
import Zey.PvP.Kits.Magma;
import Zey.PvP.Kits.Monk;
import Zey.PvP.Kits.Ninja;
import Zey.PvP.Kits.Poseidon;
import Zey.PvP.Kits.QuickDropper;
import Zey.PvP.Kits.Rain;
import Zey.PvP.Kits.Resouper;
import Zey.PvP.Kits.Snail;
import Zey.PvP.Kits.Sonic;
import Zey.PvP.Kits.Specialist;
import Zey.PvP.Kits.Stomper;
import Zey.PvP.Kits.Switcher;
import Zey.PvP.Kits.Swords;
import Zey.PvP.Kits.TheForceField;
import Zey.PvP.Kits.Thor;
import Zey.PvP.Kits.Thresh;
import Zey.PvP.Kits.TimeLord;
import Zey.PvP.Kits.Turtle;
import Zey.PvP.Kits.Viking;
import Zey.PvP.Kits.Viper;
import tk.zeynetwork.kitpvp.api.Kit;
import tk.zeynetwork.kitpvp.api.KitPvPAPI;
import tk.zeynetwork.kitpvp.kits.Anchor;
import tk.zeynetwork.kitpvp.kits.AntiTower;
import tk.zeynetwork.kitpvp.kits.Archer;
import tk.zeynetwork.kitpvp.kits.Camel;
import tk.zeynetwork.kitpvp.kits.Nenhum;
import tk.zeynetwork.kitpvp.kits.PvP;

public final class Kits {

	public static final Kit 
	NENHUM = new Nenhum(),
	PVP = new PvP(), 
	AJNIN = new Ajnin(), 
	ARCHER = new Archer(), 
	ANCHOR = new Anchor(),
	ANTITOWER = new AntiTower(), 
	ARMOR = new Armor(), 
	AVATAR = new Avatar(), 
	C4 = new Zey.PvP.Kits.C4(),
	CAMEL = new Camel(), 
	CONFUSER = new Confuser(), 
	DESHFIRE = new DeshFire(), 
	FISHERMAN = new Fisherman(),
	GLADIATOR = new Gladiator(), 
	GRAPPLER = new Grappler(), 
	HOTPOTATO = new HotPotato(), 
	HULK = new Hulk(),
	JELLYFISH = new JellyFish(), 
	KANGAROO = new Kangaroo(), 
	MADMAN = new Madman(), 
	MAGMA = new Magma(),
	MONK = new Monk(), 
	NINJA = new Ninja(), 
	POSEIDON = new Poseidon(), 
	QUICKDROPPER = new QuickDropper(),
	RAIN = new Rain(), 
	RESOUPER = new Resouper(), 
	SNAIL = new Snail(), 
	SONIC = new Sonic(),
	SPECIALIST = new Specialist(), 
	STOMPER = new Stomper(), 
	SWITCHER = new Switcher(), 
	SWORDS = new Swords(),
	FORCEFIELD = new TheForceField(), 
	THOR = new Thor(), 
	THRESH = new Thresh(), 
	TIMELORD = new TimeLord(),
	TURTLE = new Turtle(), 
	VIKING = new Viking(), 
	VIPER = new Viper();

	public static void loadKits() {
		KitPvPAPI.addKit(Kits.NENHUM);
		KitPvPAPI.addKit(Kits.PVP);
		KitPvPAPI.addKit(Kits.AJNIN);
		KitPvPAPI.addKit(Kits.ARCHER);
		KitPvPAPI.addKit(Kits.ANCHOR);
		KitPvPAPI.addKit(Kits.ANTITOWER);
		KitPvPAPI.addKit(Kits.ARMOR);
		KitPvPAPI.addKit(Kits.AVATAR);
		KitPvPAPI.addKit(Kits.C4);
		KitPvPAPI.addKit(Kits.CAMEL);
		KitPvPAPI.addKit(Kits.CONFUSER);
		KitPvPAPI.addKit(Kits.DESHFIRE);
		KitPvPAPI.addKit(Kits.FISHERMAN);
		KitPvPAPI.addKit(Kits.GLADIATOR);
		KitPvPAPI.addKit(Kits.GRAPPLER);
		KitPvPAPI.addKit(Kits.HOTPOTATO);
		KitPvPAPI.addKit(Kits.HULK);
		KitPvPAPI.addKit(Kits.JELLYFISH);
		KitPvPAPI.addKit(Kits.KANGAROO);
		KitPvPAPI.addKit(Kits.MADMAN);
		KitPvPAPI.addKit(Kits.MAGMA);
		KitPvPAPI.addKit(Kits.MONK);
		KitPvPAPI.addKit(Kits.NINJA);
		KitPvPAPI.addKit(Kits.POSEIDON);
		KitPvPAPI.addKit(Kits.QUICKDROPPER);
		KitPvPAPI.addKit(Kits.RAIN);
		KitPvPAPI.addKit(Kits.RESOUPER);
		KitPvPAPI.addKit(Kits.SNAIL);
		KitPvPAPI.addKit(Kits.SONIC);
		KitPvPAPI.addKit(Kits.SPECIALIST);
		KitPvPAPI.addKit(Kits.STOMPER);
		KitPvPAPI.addKit(Kits.SWITCHER);
		KitPvPAPI.addKit(Kits.SWORDS);
		KitPvPAPI.addKit(Kits.FORCEFIELD);
		KitPvPAPI.addKit(Kits.THOR);
		KitPvPAPI.addKit(Kits.THRESH);
		KitPvPAPI.addKit(Kits.TIMELORD);
		KitPvPAPI.addKit(Kits.TURTLE);
		KitPvPAPI.addKit(Kits.VIKING);
		KitPvPAPI.addKit(Kits.VIPER);
	}
}