package me.theigoro.theibroadcast;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§aBroadcast inicializado");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		// Parte do broadcast
		if (command.getName().equalsIgnoreCase("bc"))
			if (args.length == 0) {
				sender.sendMessage("§cUse /bc /mensagem");
				return true;
				}  
		String message = "";
		
		for (int i = 0; i < args.length; i++ ) {
		message = message +" "+ args[i];
	    }
		if (!(sender instanceof Player)) {
            Bukkit.broadcastMessage("§c§l[CONSOLE]§a " + message);    
        }else {
        	if (!sender.hasPermission("broadcast.admin")) {
        		sender.sendMessage("§cVoce precisa ser Admin ou superior para executar esse comando.");
        		return true;
        	}else {
        		sender.getServer().broadcastMessage("§c§l[AVISO]§a " + message);
        	}
        }
		
		
		if (command.getName().equalsIgnoreCase("bcreload")) {
			reloadConfig();
			sender.sendMessage("§aA configuracao do plugin foi recarregada");
		}
		if (!sender.hasPermission("broadcast.admin")) {
			sender.sendMessage("§cVocê precisa ser Admin ou superar para executar esse comando.");
			return true;
	} 
	
      return false;
	}
	
		
 
}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

