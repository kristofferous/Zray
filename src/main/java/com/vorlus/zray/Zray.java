package com.vorlus.zray;

import com.vorlus.zray.Listeners.PlayerListener;
import com.vorlus.zray.Util.Files.FileBasics;
import com.vorlus.zray.Util.MethodCenter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Zray extends JavaPlugin implements Listener {

    private static final MethodCenter methodCenter = new MethodCenter();
    private static final PlayerListener playerListener = new PlayerListener();
    private static final FileBasics fileBasics = new FileBasics();

    private static Zray instance;

    @Override
    public void onEnable() {
        loadAll();
        System.out.println(methodCenter.c("&7&l[&b&lZray&7] &fPlugin enabled!"));
    }
    public static Zray getInstance() {
        return instance;
    }
    public void loadAll() {
        instance.getServer().getPluginManager().registerEvents(playerListener, this);
        fileBasics.load();
    }
}
