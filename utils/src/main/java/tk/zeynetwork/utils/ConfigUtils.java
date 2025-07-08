package tk.zeynetwork.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigUtils {

	public static void setupDefaultConfig(Plugin plugin) {
		plugin.saveDefaultConfig();
		FileConfiguration config = plugin.getConfig();
		config.options().copyDefaults(true);
		config.options().copyHeader(true);
		plugin.saveConfig();
		plugin.getLogger().info("Configuração padrão carregada/atualizada para " + plugin.getName());
	}
}