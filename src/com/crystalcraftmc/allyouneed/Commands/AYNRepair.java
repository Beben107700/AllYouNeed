package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNRepair implements CommandExecutor{
	
	public AYNRepair(Main m){
		
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(sender instanceof Player){
			Player p = (Player)sender;
			short dura = 0;
			p.getInventory().getItemInHand().setDurability(dura);
			return  true;
		}
		else{
			sender.sendMessage("Only a player could execute that command!");
			return true;
		}
	}
}
