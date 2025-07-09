package tk.zeynetwork.kitpvp.api;

import org.bukkit.plugin.Plugin;

public final class KitPvPAPI implements KitPvP {

	private static KitPvPAPI instance;
	private Plugin plugin;

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
			throw new IllegalStateException("KitPvPAPI ainda não foi instanciada! Construa a instância no plugin primeiro.");
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
}