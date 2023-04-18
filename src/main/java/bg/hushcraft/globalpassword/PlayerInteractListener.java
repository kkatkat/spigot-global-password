package bg.hushcraft.globalpassword;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    Globalpassword plugin = Globalpassword.getPlugin(Globalpassword.class);

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!plugin.getLoggedPlayers().contains(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
