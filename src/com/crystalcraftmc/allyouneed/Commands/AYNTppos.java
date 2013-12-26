package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNTppos implements CommandExecutor{
	

	
	public AYNTppos(Main main){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		

		if(sender instanceof Player){
			
			if(args.length == 3){
				//Main code STARTS here		
				try{
				int X = Integer.parseInt(args[0]);
				int Y = Integer.parseInt(args[1]);
				int Z = Integer.parseInt(args[2]);
				Player p = (Player)sender;
				Location loc = new Location(p.getWorld(),X,Y,Z);
				p.teleport(loc);
				}catch(Exception e){
					sender.sendMessage("Enter numeral values please");
				}
				
				//Main code ENDS here
				return true;
			}
			else return false;
		}
		sender.sendMessage("Only a player could execute this command");
		return true;
	}

}
