package com.crystalcraftmc.allyouneed;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import com.crystalcraftmc.allyouneed.Commands.AYNCt;
import com.crystalcraftmc.allyouneed.Commands.AYNDefineSpawn;
import com.crystalcraftmc.allyouneed.Commands.AYNEnder;
import com.crystalcraftmc.allyouneed.Commands.AYNHeal;
import com.crystalcraftmc.allyouneed.Commands.AYNHome;
import com.crystalcraftmc.allyouneed.Commands.AYNKickall;
import com.crystalcraftmc.allyouneed.Commands.AYNRules;
import com.crystalcraftmc.allyouneed.Commands.AYNSetHome;
import com.crystalcraftmc.allyouneed.Commands.AYNSpawn;
import com.crystalcraftmc.allyouneed.Commands.AYNTpgo;
import com.crystalcraftmc.allyouneed.Listeners.BanBlocks;

public final class Main extends JavaPlugin {
	@Override
	public void onEnable() {

		// TestZone - temporary

		// TestZone/

		getLogger().info("All You Need has been enabled!");

		// BanBlocks
		new BanBlocks(this);
		// BanBlocks/

		// HomeList
		HomeListConfig HLC = new HomeListConfig(this);
		AYNSetHome.HomeListConfig = HLC;
		AYNHome.HomeListConfig = HLC;
		// HomeList/

		// Metrics
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
		}
		// Metrics/

		// Config
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		// Config/

		// Auto-update
		if (this.getConfig().getBoolean("auto-update"))
			;
		{
			// ...check for and download any new updates for the plugin.
			@SuppressWarnings("unused")
			Updater updater = new Updater(this, "all-you-need", this.getFile(),
					Updater.UpdateType.DEFAULT, true);
		}
		// Auto-update/

		// Commands
		getCommand("ct").setExecutor(new AYNCt(this));
		getCommand("ender").setExecutor(new AYNEnder(this));
		getCommand("tpgo").setExecutor(new AYNTpgo(this));
		getCommand("definespawn").setExecutor(new AYNDefineSpawn(this));
		getCommand("spawn").setExecutor(new AYNSpawn(this));
		getCommand("definehome").setExecutor(new AYNSetHome(this));
		getCommand("home").setExecutor(new AYNHome(this));
		getCommand("heal").setExecutor(new AYNHeal(this));
		getCommand("rules").setExecutor(new AYNRules(this));
		getCommand("kickall").setExecutor(new AYNKickall(this));
		// Commands/

	}

	@Override
	public void onDisable() {
		getLogger().info("All You Need has been disabled!");
		// this.saveConfig();
		// this holds the config in cache, which disallows ppl to change config
		// args and
		// reload the server.
	}
}
/*
 * Copyright (C) 2013 Justin Flory
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */