package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNCt implements CommandExecutor
{
	public AYNCt(Main main)
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
	    {	
	    	// If the player typed /wb, then do the following...
	    	if (cmd.getName().equalsIgnoreCase("ct"))
	    	{
	    		// If the sender of the command is NOT a player...
	    		if (!(sender instanceof Player))
	    		{
	    			// ...do not let the command be run.
	    			sender.sendMessage("This command can only be run by a player.");
	    		}
	    		// Otherwise...
	    		else
	    		{
	    			// ...if the sender of the command is a player...
	    			Player player = (Player) sender;
	    			
	    			// ...open a crafting table.
	    			player.openWorkbench(null, true);
	    		}
	    		// If this has happened, the function will return true. 
	    		return true;
	    	}
	    	
	        // If this hasn't happened, a value of false will be returned.
	    	return false;
	    }
	}
}