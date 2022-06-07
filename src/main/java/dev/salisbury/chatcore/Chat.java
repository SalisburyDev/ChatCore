package dev.salisbury.chatcore;

import dev.salisbury.chatcore.commands.*;
import dev.salisbury.chatcore.listeners.*;
import me.vaperion.blade.Blade;
import me.vaperion.blade.command.bindings.impl.*;
import me.vaperion.blade.command.container.impl.*;
import me.vaperion.blade.completer.impl.*;

import org.bukkit.plugin.java.JavaPlugin;

public class Chat extends JavaPlugin {

    public boolean chatMuted;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        chatMuted = false;

        registerPlugins();
    }

    private void registerPlugins() {
        this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);

        Blade.of().binding(new BukkitBindings()).binding(new DefaultBindings()).containerCreator(BukkitCommandContainer.CREATOR)
                .fallbackPrefix("chat").tabCompleter(new DefaultTabCompleter()).build()
                .register(new ChatCommand())
                .register(new BroadcastCommand())
                .register(new PingCommand());
    }

    public static Chat getInstance() {
        return getPlugin(Chat.class);
    }

}
