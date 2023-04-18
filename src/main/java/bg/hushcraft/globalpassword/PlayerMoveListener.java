package bg.hushcraft.globalpassword;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    Globalpassword plugin = Globalpassword.getPlugin(Globalpassword.class);

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent moveEvent) {
        if (!plugin.getLoggedPlayers().contains(moveEvent.getPlayer().getUniqueId())) {
            moveEvent.setCancelled(true);
        }
    }

}
