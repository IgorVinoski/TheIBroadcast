package theigoro.theibroadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheIBroadcast extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aBroadcast inicializado");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Parte do broadcast
        if (command.getName().equalsIgnoreCase("bc")) {
            if (args.length == 0) {
                sender.sendMessage("§cUse /bc <mensagem>");
                return true;
            }

            StringBuilder message = new StringBuilder();

            for (int i = 0; i < args.length; i++ ) {
                message.append(" ").append(args[i]);
            }

            //Envia o som para o player junto com a broadcast
            for (Player p : getServer().getOnlinePlayers()) {
                try {

                    p.playSound(p.getLocation(),   Sound.BLOCK_NOTE_BLOCK_PLING, 1 , 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            String msg = ChatColor.translateAlternateColorCodes('&', message.toString());
            //Broadcast executada pelo CONSOLE
            if (!(sender instanceof Player)) {
                Bukkit.broadcastMessage(ChatColor.RED + "[CONSOLE]:" + ChatColor.translateAlternateColorCodes('&', msg));

            }else {
                if (!sender.hasPermission("broadcast.admin")) {
                    sender.sendMessage("§cVoce precisa ser Admin ou superior para executar esse comando.");
                    return true;
                }else {//broadcast executada pelo ADMIN
                    sender.getServer().broadcastMessage(ChatColor.RED + "[AVISO]:" + ChatColor.translateAlternateColorCodes('&', msg));
                }
            }
        }

        //recaregamento da configuração

        if (command.getName().equals("reloadbc")) {
            reloadConfig();
            sender.sendMessage("§aA configuracao do plugin foi recarregada");
            if (!sender.hasPermission("broadcast.admin")) {
                sender.sendMessage("§cVocê precisa ser Admin ou superar para executar esse comando.");
                return true;
            }

        }


        return false;
    }

}
