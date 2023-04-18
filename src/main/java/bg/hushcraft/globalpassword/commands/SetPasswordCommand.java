package bg.hushcraft.globalpassword.commands;

import bg.hushcraft.globalpassword.Globalpassword;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetPasswordCommand implements CommandExecutor {

    Plugin plugin = Globalpassword.getPlugin(Globalpassword.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("Only in-game players can use this command");
            return true;
        }

        Player player = (Player) sender;

        if (!player.isOp()) {
            player.sendMessage("You are not allowed to use this command");
            return true;
        }

        try {
            String newPwd = args[0];

            plugin.getConfig().set("password", newPwd);
            plugin.saveConfig();

            player.sendMessage(ChatColor.DARK_GREEN + "Successfully updated password");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
