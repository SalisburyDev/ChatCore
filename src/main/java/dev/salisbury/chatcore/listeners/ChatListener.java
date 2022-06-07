package dev.salisbury.chatcore.listeners;

import dev.salisbury.chatcore.Chat;
import dev.salisbury.chatcore.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void chatMutedCheck(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (Chat.getInstance().chatMuted) {
            if (!player.hasPermission("chatcore.chat.bypass")) {
                player.sendMessage(CC.translate("&cChat is currently muted by a staff member."));
                event.setCancelled(true);
            }
        }

    }

}
