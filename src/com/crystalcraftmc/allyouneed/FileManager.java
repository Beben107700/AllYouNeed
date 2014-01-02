package com.crystalcraftmc.allyouneed;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager{
	
	private  FileConfiguration CustomConfig = null;
	private  File customConfigFile = null;
	private  Main mainfile;
	private String configname = "config.yml";
	
	public FileManager(){}
	public FileManager(Main m, String configname){
		this.mainfile = m;
		this.configname = configname;
		this.reloadFile();
	}
	
	public void reloadFile(){
		if(customConfigFile == null){
			
	        File pluginFolder = mainfile.getDataFolder();
			File fle = new File(pluginFolder,configname);
			try {
				fle.createNewFile();
			} catch (IOException e) {
			}
			customConfigFile = fle;
			
		}
		CustomConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		
	}
	
	public FileConfiguration getFile(){
		if(CustomConfig == null) reloadFile();
		reloadFile();
		return CustomConfig;
		
	}
	
	public void saveFile(){
		if(CustomConfig == null || customConfigFile == null) return;
		
		try{
			getFile().save(customConfigFile);
		}
		catch(IOException ex){
			Bukkit.getLogger().log(Level.SEVERE, "Could not save home list");
		}
	}
}
