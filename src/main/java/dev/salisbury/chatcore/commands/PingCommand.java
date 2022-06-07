package dev.salisbury.chatcore.commands;

import dev.salisbury.chatcore.utils.CC;
import dev.salisbury.chatcore.utils.PingUtil;
import me.vaperion.blade.command.annotation.*;

import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class PingCommand {

    DecimalFormat decimalFormat = new DecimalFormat("#.###");

    @Command(value = "ping", async = true, quoted = false, description = "Get self ping")
    public void pingCommand(@Sender Player player, @Name("target") Player target) {
        player.sendMessage(CC.translate("&d" + target.getName() + "&e's ping: &d" + decimalFormat.format(PingUtil.getPing(player)) + "&e ms"));
    }

}
