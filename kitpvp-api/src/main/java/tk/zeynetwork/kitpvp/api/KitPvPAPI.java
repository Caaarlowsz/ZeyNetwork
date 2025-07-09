package tk.zeynetwork.kitpvp.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class KitPvPAPI implements KitPvP {

	private static KitPvPAPI instance;
	private Plugin plugin;

	private HashSet<Warp> warps = new HashSet<>();
	private HashMap<Player, Warp> warpMap = new HashMap<>();
	private HashSet<Kit> kits = new HashSet<>();
	private HashMap<Player, Kit> kitMap = new HashMap<>();

	public KitPvPAPI(Plugin plugin) {
		if (instance != null)
			throw new IllegalStateException("KitPvPAPI já foi instanciada! Use KitPvPAPI.getInstance() para obtê-la.");
		if (plugin == null)
			throw new IllegalArgumentException("A instância do plugin não pode ser nula ao inicializar KitPvPAPI.");

		this.plugin = plugin;
		instance = this;
		plugin.getLogger().info("KitPvPAPI instanciada com sucesso! Versão: " + getApiVersion());
	}

	public static KitPvPAPI getInstance() {
		if (instance == null)
			throw new IllegalStateException(
					"KitPvPAPI ainda não foi instanciada! Construa a instância no plugin primeiro.");
		return instance;
	}

	@Override
	public Plugin getPlugin() {
		return this.plugin;
	}

	@Override
	public String getApiVersion() {
		return "0.0.0";
	}

	@Override
	public Set<Warp> getWarps() {
		return Collections.unmodifiableSet(this.warps);
	}

	@Override
	public Warp getWarp(String name) {
		return this.getWarps().stream().filter(w -> w.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	@Override
	public void addWarp(Warp warp) {
		this.warps.add(warp);
	}

	@Override
	public void removeWarp(Warp warp) {
		this.warps.remove(warp);
	}

	@Override
	public boolean hasWarp(Player player) {
		return warpMap.containsKey(player);
	}

	@Override
	public Warp getWarp(Player player) {
		return warpMap.getOrDefault(player, null);
	}

	@Override
	public void setWarp(Player player, Warp warp) {
		warpMap.put(player, warp);
	}

	@Override
	public void removeWarp(Player player) {
		warpMap.remove(player);
	}

	@Override
	public Set<Kit> getKits() {
		return Collections.unmodifiableSet(this.kits);
	}

	@Override
	public Kit getKit(String name) {
		return this.getKits().stream().filter(k -> k.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	@Override
	public void addKit(Kit kit) {
		this.kits.add(kit);
	}

	@Override
	public void removeKit(Kit kit) {
		this.kits.remove(kit);
	}

	@Override
	public boolean hasKit(Player player) {
		return this.kitMap.containsKey(player);
	}

	@Override
	public Kit getKit(Player player) {
		return this.kitMap.getOrDefault(player, null);
	}

	@Override
	public void setKit(Player player, Kit kit) {
		this.kitMap.put(player, kit);
	}

	@Override
	public void removeKit(Player player) {
		this.kitMap.remove(player);
	}
}