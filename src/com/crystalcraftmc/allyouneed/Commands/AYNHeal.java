package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNHeal implements CommandExecutor {
	Main plugin;
	public AYNHeal(Main main){
		this.plugin = main;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(args.length < 1){
			Player pl = (Player) sender;
			pl.setHealth(20);
			pl.setFoodLevel(20);
			return true;
		}
		else{
			if(plugin.getServer().getPlayer(args[0]) != null){
				Player pl = plugin.getServer().getPlayer(args[0]);
				pl.setHealth(20);
				pl.setFoodLevel(20);
				pl.sendMessage("You got healed by "+sender.getName());
				return true;
			}
			else{
				sender.sendMessage("Player not existing");
				return false;
			}
		}
		
	}

}
