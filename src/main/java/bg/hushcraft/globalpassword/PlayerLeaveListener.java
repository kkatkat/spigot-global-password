package bg.hushcraft.globalpassword;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class PlayerLeaveListener implements Listener {

    Globalpassword plugin = Globalpassword.getPlugin(Globalpassword.class);

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        plugin.removeLoggedPlayer(player.getUniqueId());

        try {
            if (plugin.getUnloggedOps().contains(player.getUniqueId())) {
                player.setOp(true);
                plugin.removeUnloggedOp(player.getUniqueId());
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
