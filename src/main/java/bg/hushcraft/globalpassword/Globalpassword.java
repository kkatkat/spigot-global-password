package bg.hushcraft.globalpassword;

import bg.hushcraft.globalpassword.commands.LoginGlobalCommand;
import bg.hushcraft.globalpassword.commands.SetPasswordCommand;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class Globalpassword extends JavaPlugin {

    private Set<UUID> unloggedOps;
    private Set<UUID> loggedPlayers;

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItemListener(), this);

        getCommand("setGlobalPassword").setExecutor(new SetPasswordCommand());
        getCommand("login").setExecutor(new LoginGlobalCommand());

        unloggedOps = new HashSet<>();
        loggedPlayers = new HashSet<>();
    }

    public Set<UUID> getUnloggedOps() {
        return this.unloggedOps;
    }

    public void addUnloggedOp(UUID uuid) {
        unloggedOps.add(uuid);
    }

    public void removeUnloggedOp(UUID uuid) {
        unloggedOps.remove(uuid);
    }

    public Set<UUID> getLoggedPlayers() {
        return this.loggedPlayers;
    }

    public void addLoggedPlayer(UUID uuid) {
        this.loggedPlayers.add(uuid);
    }

    public void removeLoggedPlayer(UUID uuid) {
        this.loggedPlayers.remove(uuid);
    }

//    @Override
//    public void onDisable() {
//        // Plugin shutdown logic
//    }
}
