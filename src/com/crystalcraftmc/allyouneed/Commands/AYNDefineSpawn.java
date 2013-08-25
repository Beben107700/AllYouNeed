package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNDefineSpawn implements CommandExecutor
{
	Main plugin;
	public AYNDefineSpawn(Main plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// Make the letter 'p' a variable for the command sender (or the player).
		Player p = (Player) sender;
		
	    {	
	    	// If the player typed /definespawn, then do the following...
	    	if (cmd.getName().equalsIgnoreCase("definespawn"))
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
	    			// ...record the world the player is in...
	    			p.getLocation().getWorld().setSpawnLocation((int)p.getLocation().getX(), 
	    					(int)p.getLocation().getY(),(int) p.getLocation().getZ());
	    			plugin.getConfig().set("spawn.world", p.getLocation().getWorld().getName());
	    			
	    			// ...record the x-position the player is in...
                    plugin.getConfig().set("spawn.x", p.getLocation().getX());
                    
                    // ...record the y-position the player is in...
                    plugin.getConfig().set("spawn.y", p.getLocation().getY());
                    
                    // ...record the z-position the player is in...
                    plugin.getConfig().set("spawn.z", p.getLocation().getZ());
                    
                    // ...save ALL of the above info to the config file...
                    plugin.saveConfig();
                    
                    // ...and tell the player that spawn was set successfully!
                    p.sendMessage(ChatColor.GREEN + "Spawn set!");
	    		}
	    		// If this has happened, the function will return true. 
	    		return true;
	    	}
	    	
	        // If this hasn't happened, a value of false will be returned.
	    	return false;
	    }
	}
}
