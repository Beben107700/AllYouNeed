package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNSpawn implements CommandExecutor
{
	Main plugin;
	public AYNSpawn(Main plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// Make the letter 'p' a variable for the command sender (or the player).
		Player p = (Player) sender;
		
	    {	
	    	// If the player typed /spawn, then do the following...
	    	if (cmd.getName().equalsIgnoreCase("spawn"))
	    	{
	    		// If the sender of the command is NOT a player...
	    		if (sender instanceof ConsoleCommandSender)
	    		{
	    			// ...do not let the command be run.
	    			sender.sendMessage("This command can only be run by a player.");
	    		}
	    		// Otherwise...
	    		else
	    		{
	    			// ...if there is no definition for spawn...
                    if (plugin.getConfig().getConfigurationSection("spawn") == null)
                    {
                    	// ...tell the player that spawn has not been set.
                    	p.sendMessage(ChatColor.RED + "The spawn has not yet been set!");
                    	return true;
                    }
                    
                    // ...if there is a definition of spawn, reference the world spawn is set in...
                    World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("spawn.world"));
                    
                    // ...reference the x-position that it is set at...
                    double x = plugin.getConfig().getDouble("spawn.x");
                    
                    // ...reference the y-position that it is set at...
                    double y = plugin.getConfig().getDouble("spawn.y");
                    
                    // ...reference the z-position that it is set at...
                    double z = plugin.getConfig().getDouble("spawn.z");
                    
                    // ...teleport the player to the referred position...
                    p.teleport(new Location(w, x, y, z));
                    
                    
                    
                    // ...and welcome the player to spawn!
                    p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("spawn-message"));
	    		}
	    		// If this has happened, the function will return true. 
	    		return true;
	    	}
	    	
	        // If this hasn't happened, a value of false will be returned.
	    	return false;
	    }
	}
}
