package tr.donsuzturk.envanteretkinlik;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class EnvanterEtkinlik extends JavaPlugin implements CommandExecutor
{
    public void onEnable() {
        this.saveDefaultConfig();
        this.getCommand("envanteretkinlik").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender.hasPermission("envanteretkinlik.admin")) {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("mesaj")));
            for (final String commandStr : this.getConfig().getStringList("komutlar")) {
                final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                final String command = commandStr;
                Bukkit.dispatchCommand((CommandSender)console, command);
            }
        }
        return true;
    }
}
