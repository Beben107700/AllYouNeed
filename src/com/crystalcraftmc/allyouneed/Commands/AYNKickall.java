package com.crystalcraftmc.allyouneed.Commands;

import java.util.Arrays;

import org.bukkit.ChatColor;
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
			message = Arrays.toString(args).replaceAll("," , " ");
			message = ChatColor.translateAlternateColorCodes('&', message);
		}
		for (Player p : plugin.getServer().getOnlinePlayers()) {
			if (p != sender) {
				p.kickPlayer(message);
			}
		}
		sender.sendMessage("§4Kicked all players with reason: §r" + message);
		return true;
	}

}
