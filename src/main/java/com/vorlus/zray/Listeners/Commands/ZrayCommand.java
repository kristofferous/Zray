package com.vorlus.zray.Listeners.Commands;

import com.vorlus.zray.Util.Files.FileBasics;
import net.minecraft.server.level.WorldServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ZrayCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("zray")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("spawn")) {

                }
            }
            commandSender.sendMessage(FileBasics.FILETYPE.CONFIG.getString("test"));
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            list.add("spawn");
        }
        return list;
    }
}
