package com.ruinscraft.sponsormapvote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
//import org.bukkit.inventory.Inventory;
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
		SVListener listener = new SVListener(this);
		pm.registerEvents(listener, this);
		
		config.options().copyDefaults(true);
		saveConfig();
		
	}
	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		if(sender instanceof Player) {
			//lower-case version of command in string format
			String lowerCmd = cmd.getName().toLowerCase();
			Inventory inv = player.getInventory();

			switch (lowerCmd) {
			case "smap":
				player.sendMessage("Command reached");
				ArrayList<ItemStack> items = new SMap().buildMap();
//				Random rand = new Random();
//				int randInt = rand.nextInt(item.size());
//				inv.addItem(item.get(randInt));
				inv.addItem(items.get(0));
				return true;

			default:
				//an error message
				player.sendMessage("Your command was not recognized.");
				return true;

			}
		}

		player.sendMessage("Your command was not recognized.");
		return true;
	}
	
	
	public ArrayList<ItemStack> buildMap() {
		for (String s : config.getConfigurationSection("maps").getKeys(false)) {

		String name = getConfig().getString("maps." + s + ".name");
	    String desc = getConfig().getString("maps" + s + ".desc");
	    int mapRef = getConfig().getInt("maps." + s + ".mapref");
		
	  
	    ItemStack map = new ItemStack(Material.FILLED_MAP, 1);
		MapMeta meta = (MapMeta) map.getItemMeta();
		
		meta.setMapId(mapRef); // deprecated but works
		meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + name);
		meta.setLore(Arrays.asList(desc));
		map.setItemMeta(meta);
		mapList.add(map);
		}

		return mapList;
	}
}
