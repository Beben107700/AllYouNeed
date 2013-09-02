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

public final class Main extends JavaPlugin
{
	@Override
    public void onEnable()
	{
		
		//TestZone - temporary
		
		//TestZone/
		
		
		getLogger().info("All You Need has been enabled!");
		
		//BanBlocks
		new BanBlocks(this);
		//BanBlocks/
		
		//HomeList
		HomeListConfig HLC = new HomeListConfig(this);
		AYNSetHome.HomeListConfig = HLC;
		AYNHome.HomeListConfig = HLC;
		//HomeList/
		
		//Metrics
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e){
		}
		//Metrics/
		
		//Config
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        //Config/
        
        //Auto-update
        if (this.getConfig().getBoolean("auto-update"));
        {
        	// ...check for and download any new updates for the plugin.
        	@SuppressWarnings("unused")
			Updater updater = new Updater(this, "all-you-need", this.getFile(), Updater.UpdateType.DEFAULT, true);
        }
        //Auto-update/
		
        //Commands
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
		//Commands/
		

	
    }
 
    @Override
    public void onDisable()
    {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("All You Need has been disabled!");
    	//this.saveConfig();
    	//this holds the config in cache, which disallows ppl to change config args and
    	//reload the server.
    }
}