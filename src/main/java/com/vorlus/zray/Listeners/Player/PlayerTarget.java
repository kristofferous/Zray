package com.vorlus.zray.Listeners.Player;


import com.vorlus.zray.Util.Files.FileBasics;
import com.vorlus.zray.Zray;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;

public class PlayerTarget {
    int targetRad = FileBasics.FILETYPE.CONFIG.getInt("mob-target-radius");
    int targetHeight = FileBasics.FILETYPE.CONFIG.getInt("mob-target-height");

    public void setTargets() {
        for (Player player : Zray.getInstance().getServer().getOnlinePlayers()) {
            for (Entity entity : player.getNearbyEntities(targetRad, targetHeight, targetRad)) {
                if (entity.getType() == EntityType.ZOMBIE) {
                    Mob mob = (Mob) entity;
                    mob.setTarget(player);
                }
            }
        }
    }
}
