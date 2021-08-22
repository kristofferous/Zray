package com.vorlus.zray;

import com.vorlus.zray.Listeners.Commands.ZrayCommand;
import com.vorlus.zray.Listeners.Player.PlayerTarget;
import com.vorlus.zray.Util.Files.FileBasics;
import com.vorlus.zray.Util.MethodCenter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;

public class Zray extends JavaPlugin implements Listener {

    private static final MethodCenter methodCenter = new MethodCenter();
    private static final PlayerTarget playerTarget = new PlayerTarget();
    private static final FileBasics fileBasics = new FileBasics();
    private static final ZrayCommand zrayCommand = new ZrayCommand();

    private static Zray instance;

    Timer timer = new Timer();

    @Override
    public void onEnable() {
        instance = this;
        loadAll();
    }

    public static Zray getInstance() {
        return instance;
    }

    public void loadAll() {
        Objects.requireNonNull(instance.getCommand("zray")).setExecutor(zrayCommand);
        Objects.requireNonNull(instance.getCommand("zray")).setTabCompleter(zrayCommand);

        fileBasics.load();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                playerTarget.setTargets();
            }
        }, 0, FileBasics.FILETYPE.CONFIG.getInt("mob-target-delay"));

        instance.getLogger().log(Level.INFO, methodCenter.c("&7&l[&b&lZray&7] &fPlugin enabled!"));
    }
}
