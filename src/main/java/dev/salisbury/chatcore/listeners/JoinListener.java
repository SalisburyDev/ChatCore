package dev.salisbury.chatcore.listeners;

import dev.salisbury.chatcore.Chat;
import dev.salisbury.chatcore.utils.CC;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);

        for (int i = 0; i < 255; i++) {
            player.sendMessage("");
        }

        for (String message : Chat.getInstance().getConfig().getStringList("JOIN_MESSAGE")) {
            player.sendMessage(CC.translate(message));
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }

}
