package com.ruinscraft.sponsormapvote;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
		PluginManager pm = getServer().getPluginManager();
		SVListener listener = new SVListener(this);
		pm.registerEvents(listener, this);
		
		if(getConfig().getString("map1") == null) {
		getConfig().set("map1","EMPTY");
		saveConfig();
		
		}
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
				ItemStack item = new ItemSmith().buildMap();
//				Random rand = new Random();
//				int randInt = rand.nextInt(item.size());
//				inv.addItem(item.get(randInt));
				inv.addItem(item);
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
}
