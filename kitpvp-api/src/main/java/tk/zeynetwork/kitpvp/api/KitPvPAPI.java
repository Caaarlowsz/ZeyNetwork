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
}