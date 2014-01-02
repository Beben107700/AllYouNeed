package com.crystalcraftmc.allyouneed.Commands;

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
		String prefix = "["+ sender.getName() + "->" + args[0] + "]";
		String message = null;
		//TODO from args[1] to args[infinite] into one string
		//maybe use for?
		
		
		reciever.sendMessage(prefix);
		sender.sendMessage(prefix);
		
		return true;
		}
		else{
			return false;
		}
	}

}
