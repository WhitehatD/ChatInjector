package me.whitehatd;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Matcher;

public class ChatInjector extends JavaPlugin implements Listener {
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {}

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onChat(AsyncPlayerChatEvent e) {

        String format = e.getFormat();
        Matcher matcher = PlaceholderAPI.getBracketPlaceholderPattern().matcher(format);
        if (matcher.find()) {
            format = PlaceholderAPI.setBracketPlaceholders(e.getPlayer(), format);
            e.setFormat(format);
        }
    }

}
