package dev.salisbury.chatcore.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PingUtil {

    public static int getPing(Player player) {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

        if (!player.getClass().getName().equals("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer")) {
            player = Bukkit.getPlayer(player.getUniqueId());
        }

        try {
            Class<?> CPClass = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
            Object craftPlayer = CPClass.cast(player);
            Method getHandle = craftPlayer.getClass().getMethod("getHandle");
            Object EntityPlayer = getHandle.invoke(craftPlayer);
            Field field = EntityPlayer.getClass().getDeclaredField("ping");
            return field.getInt(EntityPlayer);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
