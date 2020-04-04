package com.ruinscraft.sponsormapvote;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SponsorMapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        
		Inventory inv = player.getInventory();

        ArrayList<ItemStack> items = new SMap().buildMap();
		//Random rand = new Random();
		//int randInt = rand.nextInt(item.size());
		//inv.addItem(item.get(randInt));
		inv.addItem(items.get(0));
		
        player.sendMessage(ChatColor.YELLOW + "Map given.");

        return true;
    }

}
