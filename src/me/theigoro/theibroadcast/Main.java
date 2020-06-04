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
		if (command.getName().equalsIgnoreCase("bc")) {
			
			if(args.length == 0)return true;
            String message = null;
            for (int i = 0; i < args.length; i++) {
                message = message + args[i];
            }

            if (!(sender instanceof Player)) {
                Bukkit.broadcastMessage("§c§l[CONSOLE]§a " + message);
                
            }else {
                if (!sender.hasPermission("broadcast.send")) {
                sender.sendMessage("§fVocê não tem permissão para executar esse comando.");
                return true;
                } else {
                 sender.getServer().broadcastMessage("§c§l[AVISO]§a " + message);
                }
            }
		}
      return false;
	}
}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

