package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNKickall implements CommandExecutor {
	Main plugin;

	public AYNKickall(Main m) {
		plugin = m;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		String message = "Kicked by an operator";
		if (args.length > 0) {
			message = "";			
			for(int i = 0; i<args.length; i++){
				
					String thing = args[i] + " ";
					message += thing;
				
			}
		}
		for (Player p : plugin.getServer().getOnlinePlayers()) {
			if (p != sender) {
				p.kickPlayer("§4Kicked with reason: "+message);
			}
		}
		sender.sendMessage("§4Kicked all players with reason: §r" + message);
		return true;
	}

}
