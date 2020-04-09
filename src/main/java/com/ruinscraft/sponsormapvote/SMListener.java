package com.ruinscraft.sponsormapvote;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;

public class SMListener implements Listener {

	public SMListener(SMap plugin) {

	}

	//EventHandler
	@EventHandler
	public void onPrepareItemCraft(PrepareItemCraftEvent event) {
		//		for (ItemStack item : event.getInventory().getContents()) {
		//			if (item == null) continue;
		//			if (item.getType() != Material.FILLED_MAP) continue;
		//			then i think theres a Map object u cast the itemstack to? or u cast the itemmeta? idk
		//					for (ItemStack map : SMap.getItems() (?)) {
		//						if (map.getID() == item.getMap().getID()) {
		//							event.setCancelled(true);
		//							return;
		//						}
		//					}
		//		}
	}
}