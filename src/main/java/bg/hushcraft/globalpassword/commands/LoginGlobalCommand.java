package bg.hushcraft.globalpassword.commands;

import bg.hushcraft.globalpassword.Globalpassword;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class LoginGlobalCommand implements CommandExecutor {

    Globalpassword plugin = Globalpassword.getPlugin(Globalpassword.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println("Only in-game players can use this command");
            return true;
        }

        try {
            Player player = (Player) sender;

            String actualPassword = plugin.getConfig().getString("password");
            String providedPassword = args[0];

            if (!actualPassword.equals(providedPassword)) {
                player.kickPlayer("Incorrect password");
            } else {
                System.out.println("Player UUID is: " + player.getUniqueId());

                //player.setWalkSpeed(0.2f);
                player.setInvulnerable(false);
                player.setGameMode(GameMode.SURVIVAL);
                plugin.addLoggedPlayer(player.getUniqueId());


                if (plugin.getUnloggedOps().contains(player.getUniqueId())) {
                    player.setOp(true);
                    plugin.removeUnloggedOp(player.getUniqueId());
                    player.sendMessage(ChatColor.DARK_GREEN + "Restored operator privileges!");
                }

                player.sendMessage(ChatColor.DARK_GREEN + "Logged in successfully!");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
