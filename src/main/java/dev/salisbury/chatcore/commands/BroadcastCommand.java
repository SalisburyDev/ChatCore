package dev.salisbury.chatcore.commands;

import dev.salisbury.chatcore.utils.CC;
import me.vaperion.blade.command.annotation.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BroadcastCommand {

    @Command(value = "broadcast", async = true, quoted = false, description = "Broadcasts a message to all players")
    @Permission(value = "chatcore.chat.broadcast", message = "You do not have permission to execute this command.")
    public void broadcastCommand(@Sender Player player, @Combined String broadcast) {
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage(CC.translate("&d[&d&lBROADCAST&d] &f" + broadcast));
        Bukkit.getServer().broadcastMessage("");
    }

}
