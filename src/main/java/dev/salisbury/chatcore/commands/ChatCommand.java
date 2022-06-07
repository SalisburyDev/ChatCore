package dev.salisbury.chatcore.commands;

import dev.salisbury.chatcore.Chat;
import dev.salisbury.chatcore.utils.CC;
import me.vaperion.blade.command.annotation.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class ChatCommand {

    private final List<String> helpMessage = Arrays.asList(
        "&d&lCHAT CORE COMMANDS",
        "&7&m-------------------------------------------------",
        "&d/chat &7- Shows this help message",
        "&d/coreinfo &7- Shows chat core information",
        "&d/mutechat &7- Mutes the chat",
        "&d/clearchat &7- Clears the chat",
        "&d/broadcast &7- Broadcast message to chat",
        "&7&m-------------------------------------------------"
    );

    private final List<String> plInfoMessage = Arrays.asList(
        "&d&lCHAT CORE INFORMATION",
        "&7&m-------------------------------------------------",
        "&dAuthor: &7Salisbury",
        "&dVersion: &7" + Chat.getInstance().getDescription().getVersion(),
        "&dStatus: &cBETA",
        "&7&m-------------------------------------------------"
    );

    @Command(value = "chat", async = true, quoted = false, description = "Main command for the chat core plugin")
    @Permission(value = "chatcore.chat", message = "You do not have permission to execute this command.")
    public void chatCommand(@Sender Player player) {
        helpMessage.forEach(string -> player.sendMessage(CC.translate(string)));
    }

    @Command(value = "coreinfo", async = true, quoted = false, description = "Information command for the chat core plugin")
    @Permission(value = "chatcore.coreinfo", message = "You do not have permission to execute this command.")
    public void coreInfoCommand(@Sender Player player) {
        plInfoMessage.forEach(string -> player.sendMessage(CC.translate(string)));
    }

    @Command(value = "clearchat", async = true, quoted = false, description = "Clears the chat")
    @Permission(value = "chatcore.chat.clear", message = "You do not have permission to execute this command.")
    public void clearChatCommand(@Sender Player player) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 255; i++) {
                p.sendMessage("");
            }
            p.sendMessage(CC.translate("&cChat has been cleared by staff member."));
        }
    }

    @Command(value = "mutechat", async = true, quoted = false, description = "Mutes the chat")
    @Permission(value = "chatcore.chat.mute", message = "You do not have permission to execute this command.")
    public void muteChatCommand(@Sender Player player) {
        if (Chat.getInstance().chatMuted) {
            Chat.getInstance().chatMuted = false;
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(CC.translate("&aChat has been unmuted by staff member."));
            }
        } else {
            Chat.getInstance().chatMuted = true;
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(CC.translate("&cChat has been muted by staff member."));
            }
        }
    }

    @Command(value = "broadcast", async = true, quoted = false, description = "Broadcasts a message to all players")
    @Permission(value = "chatcore.chat.broadcast", message = "You do not have permission to execute this command.")
    public void broadcastCommand(@Sender Player player, @Combined String broadcast) {
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage(CC.translate("&d[&d&lBROADCAST&d] &f" + broadcast));
        Bukkit.getServer().broadcastMessage("");
    }

}
