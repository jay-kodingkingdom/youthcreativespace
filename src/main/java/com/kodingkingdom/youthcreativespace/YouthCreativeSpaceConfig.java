package com.kodingkingdom.youthcreativespace;

import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;

public enum YouthCreativeSpaceConfig {

	YOUTH("youthcreativespace.youth"),
	CREATIVE("youthcreativespace.creative"),
	SPACE("youthcreativespace.space")
	;
	
	public final String config;
	Location loc;
	
	private YouthCreativeSpaceConfig(String Config){
		config=Config;}
		
	public static void loadConfig(){
		YouthCreativeSpacePlugin plugin = YouthCreativeSpacePlugin.getPlugin();
		FileConfiguration config = plugin.getConfig();
		
		try{
			if (config.getString(YOUTH.config)!=null){
				String[] youthArgs=config.getString(YOUTH.config).split("~");
				if (youthArgs.length!=6)throw new IllegalStateException();
				YOUTH.loc=new Location(plugin.getServer().createWorld(new WorldCreator(youthArgs[0])),
						Double.parseDouble(youthArgs[1]),
						Double.parseDouble(youthArgs[2]),
						Double.parseDouble(youthArgs[3]),
						Float.parseFloat(youthArgs[4]),
						Float.parseFloat(youthArgs[5]));}

			if (config.getString(CREATIVE.config)!=null){
				String[] creativeArgs=config.getString(CREATIVE.config).split("~");
				if (creativeArgs.length!=6)throw new IllegalStateException();
				CREATIVE.loc=new Location(plugin.getServer().createWorld(new WorldCreator(creativeArgs[0])),
						Double.parseDouble(creativeArgs[1]),
						Double.parseDouble(creativeArgs[2]),
						Double.parseDouble(creativeArgs[3]),
						Float.parseFloat(creativeArgs[4]),
						Float.parseFloat(creativeArgs[5]));}

			if (config.getString(SPACE.config)!=null){
				String[] spaceArgs=config.getString(SPACE.config).split("~");
				if (spaceArgs.length!=6)throw new IllegalStateException();
				SPACE.loc=new Location(plugin.getServer().createWorld(new WorldCreator(spaceArgs[0])),
						Double.parseDouble(spaceArgs[1]),
						Double.parseDouble(spaceArgs[2]),
						Double.parseDouble(spaceArgs[3]),
						Float.parseFloat(spaceArgs[4]),
						Float.parseFloat(spaceArgs[5]));}
			
			plugin.getLogger().info("Config successfully loaded");}
		
		catch(Exception e){
			plugin.getLogger().severe("Could not load config!");
			plugin.getLogger().severe("ERROR MESSAGE: "+e.getMessage());
			e.printStackTrace();
			config.set("youthcreativespace.ERROR", true);}}
			
	
	public static void saveConfig(){
		YouthCreativeSpacePlugin plugin = YouthCreativeSpacePlugin.getPlugin();
		FileConfiguration config = plugin.getConfig();

		if (config.isSet("youthcreativespace.ERROR")){
			plugin.getLogger().info("Config state invalid, will not save");
			return;}
		try{
			for(String key : config.getKeys(false)){
				 config.set(key,null);}

			config.set(YOUTH.config,
					YOUTH.loc.getWorld().getName()+"~"+
					YOUTH.loc.getX()+"~"+
					YOUTH.loc.getY()+"~"+
					YOUTH.loc.getZ()+"~"+
					YOUTH.loc.getYaw()+"~"+
					YOUTH.loc.getPitch());
			if (CREATIVE.loc!=null) config.set(CREATIVE.config,
					CREATIVE.loc.getWorld().getName()+"~"+
					CREATIVE.loc.getX()+"~"+
					CREATIVE.loc.getY()+"~"+
					CREATIVE.loc.getZ()+"~"+
					CREATIVE.loc.getYaw()+"~"+
					CREATIVE.loc.getPitch());
			if (SPACE.loc!=null) config.set(SPACE.config,
					SPACE.loc.getWorld().getName()+"~"+
					SPACE.loc.getX()+"~"+
					SPACE.loc.getY()+"~"+
					SPACE.loc.getZ()+"~"+
					SPACE.loc.getYaw()+"~"+
					SPACE.loc.getPitch());			

			plugin.saveConfig();
			plugin.getLogger().info("Config successfully saved");}
		catch(Exception e){
			plugin.getLogger().severe("Could not save config!");
			plugin.getLogger().severe("ERROR MESSAGE: "+e.getMessage());
			e.printStackTrace();}}}
