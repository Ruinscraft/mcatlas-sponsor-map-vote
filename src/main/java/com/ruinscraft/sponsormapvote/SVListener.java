package com.ruinscraft.sponsormapvote;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
 
public class SVListener implements Listener {
 public SVListener(SMap plugin) {
	 
 }
 
 //EventHandler
 @EventHandler
 public void onPlayerJoin(PlayerJoinEvent event) {
	 event.getPlayer().sendMessage("SV Stuff works");
 }
 

}