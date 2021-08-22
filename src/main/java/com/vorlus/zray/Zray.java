package com.vorlus.zray;

import com.vorlus.zray.Listeners.PlayerListener;
import com.vorlus.zray.Util.Files.FileBasics;
import com.vorlus.zray.Util.MethodCenter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Zray extends JavaPlugin implements Listener {

    private static final MethodCenter methodCenter = new MethodCenter();
    private static final PlayerListener playerListener = new PlayerListener();
    private static final FileBasics fileBasics = new FileBasics();

    public static Zray instance;

    @Override
    public void onEnable() {
        instance = this;
        loadAll();
        getLogger().log(Level.INFO, methodCenter.c("&7&l[&b&lZray&7] &fPlugin enabled!"));
    }
    public static Zray getInstance() {
        return instance;
    }
    public void loadAll() {
        instance.getServer().getPluginManager().registerEvents(playerListener, this);
        fileBasics.load();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("zray")) {
            sender.sendMessage(FileBasics.FILETYPE.CONFIG.getString("test"));
        }

        return false;
    }
}
