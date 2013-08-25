package com.crystalcraftmc.allyouneed;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
public class BanBlocks implements Listener {
	Main plugin;
	String bmsg = (ChatColor.GRAY + "You are not allowed to place this block!");
	public BanBlocks(Main m){
		plugin = m;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		
		List<String> bannedlist = plugin.getConfig().getStringList("BannedBlocks");
		
		for(String s : bannedlist){
			//converting the string to int
			int BannedId = Integer.parseInt(s);
			
			if(event.getBlock().getTypeId() == BannedId  && 
					!(event.getPlayer().hasPermission("ayn.usebannedblocks"))){
				
				event.setCancelled(true);
				
				event.getPlayer().sendMessage(bmsg);
				
			}
			
		}
	}
	@EventHandler
	public void onPlayerInteraction(PlayerInteractEvent event){
		//LAVA
		if(event.getItem().getType() == Material.LAVA_BUCKET && plugin.getConfig().getBoolean("ban-lava")&& 
				!(event.getPlayer().hasPermission("ayn.usebannedblocks"))){
			event.setCancelled(true);
			event.getPlayer().sendMessage(bmsg);
		}
		//WATER
		if(event.getItem().getType() == Material.WATER_BUCKET && plugin.getConfig().getBoolean("ban-water") &&
				!(event.getPlayer().hasPermission("ayn.usebannedblocks"))){
			event.setCancelled(true);
			event.getPlayer().sendMessage(bmsg);
		}
	}
	
}
