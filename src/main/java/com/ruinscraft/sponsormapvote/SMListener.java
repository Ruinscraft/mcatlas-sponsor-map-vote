package com.ruinscraft.sponsormapvote;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.inventory.Inventory;

public class SMListener implements Listener {

	public SMListener(SMap plugin) {

	}

	//Method to prevent duplication of maps in a crafting table
	@EventHandler
	public void onPlayerCraftEvent(CraftItemEvent event) {
		Player player = Bukkit.getPlayer(event.getWhoClicked().getName());

		for (ItemStack item : event.getInventory().getContents()) {

			if (item == null) continue;
			if (item.getType() != Material.FILLED_MAP) continue;
			for (ItemStack map : SponsorMapCommand.getMaps() ) {
				if (((MapMeta) map.getItemMeta()).getMapId() == ((MapMeta) item.getItemMeta()).getMapId()) {				
					event.setCancelled(true);
					return;
				}
			}
		}
	}
}