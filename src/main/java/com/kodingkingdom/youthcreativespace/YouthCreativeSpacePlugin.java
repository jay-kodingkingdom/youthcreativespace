package com.kodingkingdom.youthcreativespace;
import java.util.logging.Level;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class YouthCreativeSpacePlugin extends JavaPlugin implements Listener{
		
	YouthCreativeSpace youthCreativeSpace;
	
	@Override
    public void onEnable(){
    	youthCreativeSpace=new YouthCreativeSpace(this);
    	youthCreativeSpace.Live();} 
    @Override
    public void onDisable(){youthCreativeSpace.Die();}
    
    static YouthCreativeSpacePlugin instance=null;
    public YouthCreativeSpacePlugin(){
    	super();
    	instance=this;}
    public static YouthCreativeSpacePlugin getPlugin(){
    	return instance;}
    public static void say(String msg){
    	instance.getLogger().log(Level.INFO//Level.FINE
    			, msg);}
    public static void debug(String msg){
    	instance.getLogger().log(Level.INFO//Level.FINE
    			, msg);}}