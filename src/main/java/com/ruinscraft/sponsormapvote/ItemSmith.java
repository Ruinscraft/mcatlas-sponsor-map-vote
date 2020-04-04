package com.ruinscraft.sponsormapvote;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemSmith extends JavaPlugin {

	public FileConfiguration config = getConfig();
	private static ArrayList<ItemStack> mapList = new ArrayList<ItemStack>();

	public ItemStack buildMap() {
//		for (String s : config.getConfigurationSection("maps").getKeys(false)) {

			String name = getConfig().getString("maps." + "map1" + ".name");
			String desc = getConfig().getString("maps" + "map1" + ".desc");
			int mapRef = getConfig().getInt("maps." + "map1" + ".mapref");

			ItemStack map = new ItemStack(Material.FILLED_MAP, 1);
			MapMeta meta = (MapMeta) map.getItemMeta();
			meta.setMapId(mapRef); // deprecated but works
			meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + name);
			meta.setLore(Arrays.asList(desc));
			map.setItemMeta(meta);
			mapList.add(map);
//		}
		return map;
	}
}