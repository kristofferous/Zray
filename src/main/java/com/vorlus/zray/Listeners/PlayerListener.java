package com.vorlus.zray.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        System.out.println("Player moved");
        for (Entity entity : event.getPlayer().getNearbyEntities(42, 2, 42)) {
            if (!(entity instanceof Player)) {
                if (entity.getType() == EntityType.COW) {
                    System.out.println("Met a COW");
                }
            } else {
                System.out.println("Is player");
            }
        }
    }
}
