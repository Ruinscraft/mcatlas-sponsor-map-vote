/* ============================
 * SPONSOR MAP VOTE           
 * Icedragon789's First Plugin
 * ============================
 */ 


package com.ruinscraft.sponsormapvote;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SMap extends JavaPlugin {

	public static ArrayList<ItemStack> mapList = new ArrayList<ItemStack>();

	public FileConfiguration config = getConfig();

	private static SMap instance;

	public static SMap getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {

		instance = this;

		getLogger().info("onEnable has been invoked!");
		PluginManager pm = getServer().getPluginManager();
		SMListener listener = new SMListener(this);
		pm.registerEvents(listener, this);

		//set smap as a command
		this.getCommand("smap").setExecutor(new SponsorMapCommand());

		config.options().copyDefaults(true);
		saveConfig();

	}
	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");

	}

	//builds a random map from yaml (must fill)
	public ArrayList<ItemStack> buildMaps() {
		for (String s : config.getConfigurationSection("maps").getKeys(false)) {

			String name = getConfig().getString("maps." + s + ".name");
			int mapRef = getConfig().getInt("maps." + s + ".mapref");

			ItemStack map = new ItemStack(Material.FILLED_MAP, 1);

			MapMeta meta = (MapMeta) map.getItemMeta();

			meta.setMapId(mapRef); // deprecated but works
			meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + name);
			map.setItemMeta(meta);
			mapList.add(map);
		}
		return mapList;
	}
}
