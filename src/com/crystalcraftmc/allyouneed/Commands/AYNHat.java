package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.crystalcraftmc.allyouneed.Main;

public class AYNHat implements CommandExecutor{
	
	public AYNHat(Main m){
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(sender instanceof Player){
			
			
			Player p = (Player)sender;
			
			if(p.getItemInHand().getAmount() == 1){
			ItemStack stack = p.getItemInHand();
			ItemStack helm = p.getInventory().getHelmet();
			p.getInventory().setHelmet(stack);
			p.getInventory().setItemInHand(helm);
			p.sendMessage("You just got a brand new hat");
			}
			else{
				p.sendMessage("You may only hold one item in that slot to make a hat of it");
			}
			return true;
		}
		else{
			sender.sendMessage("Only a player is allowed to execute this command");
			return true;
		}
	}

}
