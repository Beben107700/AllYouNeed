package com.crystalcraftmc.allyouneed.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.crystalcraftmc.allyouneed.Main;

public class AYNFly implements CommandExecutor {

	private Main plugin;

	public AYNFly(Main main) {

		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if ((sender instanceof Player)) {

			if (args.length < 1) {
				Player p = (Player) sender;
				Boolean flying = p.isFlying();
				p.setAllowFlight(!flying);
				p.setFlying(!flying);
				p.sendMessage("Fly mode changed!");
				return true;
			} else {
				if (plugin.getServer().getPlayer(args[0]) != null) {
					Player pl = plugin.getServer().getPlayer(args[0]);
					boolean flying = pl.isFlying();
					pl.setAllowFlight(!flying);
					pl.setFlying(!flying);
					
					pl.sendMessage(sender.getName() + " changed your fly mode");

					return true;
				} else {
					sender.sendMessage("Player not existing");
					return false;
				}
			}
		} else {
			sender.sendMessage("Only a player could execute this command");
			return true;
		}

	}

}
