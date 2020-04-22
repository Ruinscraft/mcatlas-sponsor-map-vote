package com.ruinscraft.sponsormapvote;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SponsorMapCommand implements CommandExecutor {
	public static ArrayList<ItemStack> items = SMap.getInstance().buildMaps();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}

		Player player = (Player) sender;

		Inventory inv = player.getInventory();

		Random rand = new Random();
		int randInt = rand.nextInt(items.size());
		inv.addItem(items.get(randInt));

		player.sendMessage(ChatColor.YELLOW + "Exclusive sponsor map given to " + player.getName() +"!");

		return true;
	}

	public static ArrayList<ItemStack> getMaps() {
		return items;
	}
}
