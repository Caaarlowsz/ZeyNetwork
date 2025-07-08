package tk.zeynetwork.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ClassGetter {

	private final Plugin plugin;
	private final String packageName;

	public ClassGetter(Plugin plugin, String packageName) {
		this.plugin = plugin;
		this.packageName = packageName;
	}

	/**
	 * Scans the plugin's JAR for classes within the specified package that
	 * implement the given interface. This version is compatible with
	 * Bukkit/PaperSpigot 1.7.10 by using CodeSource.
	 *
	 * @param interfaceClass The interface to check for implementation (e.g.,
	 *                       Listener.class).
	 * @param <T>            The type of the interface.
	 * @return A set of Class objects that implement the specified interface.
	 */
	public <T> Set<Class<? extends T>> getClassesImplementing(Class<T> interfaceClass) {
		Set<Class<? extends T>> classes = new HashSet<>();
		String packagePath = packageName.replace('.', '/');

		CodeSource codeSource = plugin.getClass().getProtectionDomain().getCodeSource();
		if (codeSource == null) {
			plugin.getLogger().severe("Could not get CodeSource for plugin. Cannot scan classes.");
			return classes;
		}

		URL jarUrl = codeSource.getLocation();
		if (jarUrl == null) {
			plugin.getLogger().severe("Could not get JAR URL from CodeSource. Cannot scan classes.");
			return classes;
		}

		try {
			String jarPath = URLDecoder.decode(jarUrl.getFile(), "UTF-8");
			if (!jarPath.endsWith(".jar")) {
				plugin.getLogger()
						.warning("Plugin path does not end with .jar, skipping direct JAR scan. Path: " + jarPath);
				return classes;
			}

			File pluginJarFile = new File(jarPath);
			if (!pluginJarFile.exists()) {
				plugin.getLogger().severe("Plugin JAR file does not exist at: " + pluginJarFile.getAbsolutePath());
				return classes;
			}

			try (JarFile jarFile = new JarFile(pluginJarFile)) {
				Enumeration<JarEntry> entries = jarFile.entries();
				while (entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					String name = entry.getName();

					if (name.startsWith(packagePath) && name.endsWith(".class")) {
						String className = name.replace('/', '.').substring(0, name.length() - 6);
						try {
							Class<?> clazz = Class.forName(className, true, plugin.getClass().getClassLoader());
							if (interfaceClass.isAssignableFrom(clazz) && !clazz.isInterface()
									&& !clazz.isAnonymousClass() && !clazz.isEnum()) {
								classes.add(clazz.asSubclass(interfaceClass));
							}
						} catch (ClassNotFoundException | NoClassDefFoundError e) {
							plugin.getLogger()
									.warning("Could not load class " + className + " during scan: " + e.getMessage());
						}
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			plugin.getLogger().severe("UTF-8 encoding not supported (critical error): " + e.getMessage());
		} catch (IOException e) {
			plugin.getLogger().severe("Error scanning plugin JAR file: " + e.getMessage());
		}
		return classes;
	}

	/**
	 * Instantiates and registers all classes found in the specified package that
	 * implement the Listener interface.
	 */
	public void registerListeners() {
		PluginManager pluginManager = Bukkit.getPluginManager();
		int index = 0;
		for (Class<? extends Listener> listenerClass : getClassesImplementing(Listener.class)) {
			try {
				Listener listener = listenerClass.getDeclaredConstructor().newInstance();
				pluginManager.registerEvents(listener, plugin);
				index++;
			} catch (Exception e) {
				plugin.getLogger().severe("Failed to instantiate or register listener " + listenerClass.getSimpleName()
						+ ": " + e.getMessage());
			}
		}
		plugin.getLogger().info("Registered " + index + " listeners.");
	}
}