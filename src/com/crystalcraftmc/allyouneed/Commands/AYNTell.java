package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNTell implements CommandExecutor{
	
	private Main plugin;
	public AYNTell(Main m){	
		plugin = m;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(args.length >=2 &&  plugin.getServer().getPlayer(args[0]) != null){
		
		Player reciever = plugin.getServer().getPlayer(args[0]);
		String prefix = ChatColor.GRAY+ "["+ sender.getName() + "->" + reciever.getName() + "]";
		String message = "";
		
		for(int i = 0; i<args.length; i++){
			if(i != 0){
				String thing = args[i] + " ";
				message += thing;
			}
		}
		
		
		String endresult = prefix + message;
		reciever.sendMessage(endresult);
		sender.sendMessage(endresult);
		
		return true;
		}
		else{
			return false;
		}
	}
}
