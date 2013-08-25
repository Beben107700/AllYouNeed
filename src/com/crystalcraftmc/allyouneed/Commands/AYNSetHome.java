package com.crystalcraftmc.allyouneed.Commands;



import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.HomeListConfig;
import com.crystalcraftmc.allyouneed.Main;


public class AYNSetHome implements CommandExecutor{
	
	Main plugin;
	
	
	public AYNSetHome(Main plugin)
	{
		this.plugin = plugin;
	}
	
	public static HomeListConfig HomeListConfig = new HomeListConfig();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[]args){
		
		if(label.equalsIgnoreCase("definehome")){
			
			
			if(sender instanceof ConsoleCommandSender){
				sender.sendMessage(ChatColor.RED + "This command can only be run by a player");
				return true;
			}
			else{
				Player sder = (Player) sender;
				double X = sder.getLocation().getX();
				double Y = sder.getLocation().getY();
				double Z = sder.getLocation().getZ();
				
				String sdername = sder.getName();
				HomeListConfig.getHomeList().set(sdername + ".X", X);
				HomeListConfig.getHomeList().set(sdername+".Y", Y);
				HomeListConfig.getHomeList().set(sdername+".Z", Z);
				HomeListConfig.savehomelist();
				
				sender.sendMessage(ChatColor.GREEN + "Home set!");
				return true;
			}

		}
		else return false;
		
	}

}
