package bg.hushcraft.globalpassword;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {

    Globalpassword plugin = Globalpassword.getPlugin(Globalpassword.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage("Welcome back " + ChatColor.DARK_AQUA + player.getDisplayName());
        player.sendMessage(ChatColor.RED + "You are not logged in. Use /login <password> to log in");
        player.sendMessage(ChatColor.RED + "Log in to disable jail");

        //player.setWalkSpeed(0);
        player.setInvulnerable(true);
        player.setGameMode(GameMode.ADVENTURE);

        if (player.isOp()) {
            player.setOp(false);
            plugin.addUnloggedOp(player.getUniqueId());
        }



    }
}
