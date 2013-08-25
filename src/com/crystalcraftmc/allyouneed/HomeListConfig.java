package com.crystalcraftmc.allyouneed;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class HomeListConfig extends JavaPlugin{
	private FileConfiguration CustomConfig = null;
	private File customConfigFile = null;
	private Main mainfile;
	
	public HomeListConfig(){}
	
	public HomeListConfig(Main m){
		this.mainfile = m;
	}
	
	public void reloadHomeList(){//reloads (or creates) the homelist
		if(customConfigFile == null){
			
	        File pluginFolder = this.mainfile.getDataFolder();
			File fle = new File(pluginFolder,"homelist.yml");	
			try {
				fle.createNewFile();
			} catch (IOException e) {
			}
			customConfigFile = fle;
			
		}
		CustomConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		
	}
	
	public FileConfiguration getHomeList(){//gets the configuration of homelist
		if(CustomConfig == null) reloadHomeList();
		return CustomConfig;
	}
	
	public void savehomelist(){
		if(CustomConfig == null || customConfigFile == null) return;
		
		try{
			getHomeList().save(customConfigFile);
		}
		catch(IOException ex){
			Bukkit.getLogger().log(Level.SEVERE, "Could not save home list");
		}
	}
}
