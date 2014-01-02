package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.FileManager;
import com.crystalcraftmc.allyouneed.Main;

public class AYNHungerLock implements CommandExecutor{
	
	private FileManager list;
	public AYNHungerLock(Main m, FileManager lst){
		list = lst;
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player)sender;
			
			
			if(list.getFile().getBoolean(p.getName())){
			list.getFile().set(p.getName(), false);
			p.sendMessage("Food level unlocked");
			list.saveFile();
			}
			else{
				list.getFile().set(p.getName(), true);
				p.sendMessage("Food level locked");
				list.saveFile();
			}
			return true;
		}
		else{
			sender.sendMessage("Only a player could execute this command");
			return true;
		}
	}

}
