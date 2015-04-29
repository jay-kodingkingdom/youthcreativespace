package com.kodingkingdom.youthcreativespace;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class YouthCreativeSpace{	
		
	YouthCreativeSpacePlugin plugin;

	public void Live(){YouthCreativeSpaceConfig.loadConfig();}
	public void Die(){YouthCreativeSpaceConfig.saveConfig();}
	
	YouthCreativeSpace(YouthCreativeSpacePlugin Plugin){
		plugin=Plugin;
		plugin.getCommand("youth").setExecutor(new CommandExecutor(){
			@Override
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {				
				if (sender instanceof Player){
					if (sender.isOp() && args.length==1&&args[0].equals("is")) YouthCreativeSpaceConfig.YOUTH.loc=((Player) sender).getLocation();
					else if (YouthCreativeSpaceConfig.YOUTH.loc!=null) ((Player) sender).teleport(YouthCreativeSpaceConfig.YOUTH.loc);}
				else{
					sender.sendMessage("Only players can use this!");}
				return true;}});
		plugin.getCommand("creative").setExecutor(new CommandExecutor(){
			@Override
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {				
				if (sender instanceof Player){
					if (sender.isOp() && args.length==1&&args[0].equals("is")) YouthCreativeSpaceConfig.CREATIVE.loc=((Player) sender).getLocation();
					else if (YouthCreativeSpaceConfig.CREATIVE.loc!=null) ((Player) sender).teleport(YouthCreativeSpaceConfig.CREATIVE.loc);}
				else{
					sender.sendMessage("Only players can use this!");}
				return true;}});
		plugin.getCommand("space").setExecutor(new CommandExecutor(){
			@Override
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {				
				if (sender instanceof Player){
					if (sender.isOp() && args.length==1&&args[0].equals("is")) YouthCreativeSpaceConfig.SPACE.loc=((Player) sender).getLocation();
					else if (YouthCreativeSpaceConfig.SPACE.loc!=null) ((Player) sender).teleport(YouthCreativeSpaceConfig.SPACE.loc);}
				else{
					sender.sendMessage("Only players can use this!");}
				return true;}});}}

