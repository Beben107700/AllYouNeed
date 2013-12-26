package com.crystalcraftmc.allyouneed.Listeners;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.crystalcraftmc.allyouneed.Main;


public class BanBlocks implements Listener {
	
	Main plugin;
	private String bmsg = (ChatColor.GRAY + "You are not allowed to place this block!");
	private List<String> bannedlist;
	
	public BanBlocks(Main m){
		plugin = m;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		bannedlist = plugin.getConfig().getStringList("BannedBlocks");
		//Here i take the list of banned blocks
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		
		/*List<String> bannedlist = plugin.getConfig().getStringList("BannedBlocks");
		 * I'm not taking the list of banned blocks each time we place a block, i only load it when the server starts.
		 * this reduces the RAM usage
		 */
		
		for(String s : bannedlist){
			//converting the string to int
			int BannedId = Integer.parseInt(s);
			
			if(event.getBlock().getType().getId() == BannedId  && 
					!(event.getPlayer().hasPermission("ayn.usebannedblocks"))){
				
				event.setCancelled(true);
				
				event.getPlayer().sendMessage(bmsg);
				
			}
			
		}
	}
}
