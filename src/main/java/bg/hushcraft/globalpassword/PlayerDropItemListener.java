package bg.hushcraft.globalpassword;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {

    Globalpassword plugin = Globalpassword.getPlugin(Globalpassword.class);

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (!plugin.getLoggedPlayers().contains(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
