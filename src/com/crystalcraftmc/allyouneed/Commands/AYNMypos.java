package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNMypos implements CommandExecutor{
	
	public AYNMypos(Main main){
		
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			Location loc = p.getLocation();
			
			String world = loc.getWorld().getName();
			int x = loc.getBlockX();
			int y = loc.getBlockY();
			int z = loc.getBlockZ();
			
			sender.sendMessage("You are in "+ world + " at X: "+x + " Y:" + y + " Z: "+z);
			return true;
		}else{
			sender.sendMessage("Only a player could execute this command");
			return true;
		}
	}

}
