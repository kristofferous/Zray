package com.vorlus.zray.Util.Files;

import com.vorlus.zray.Zray;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileBasics {

    List<FILETYPE> types = new ArrayList<>();

    public void load() {
        types.clear();
        for (FILETYPE type : FILETYPE.values()) {
            type.load();
            types.add(type);
        }
    }
    public enum FILETYPE {
        CONFIG( "config");

        private final File file;
        private final YamlConfiguration fileConfiguration = new YamlConfiguration();
        private final String fileName;

        FILETYPE(String str) {
            this.fileName = str + ".yml";
            this.file = new File(Zray.getInstance().getDataFolder(), fileName);
        }

        //PUBLIC
        public String getString(String path) {
            return fileConfiguration.getString(path);
        }
        public boolean getBoolean(String path) {
            return fileConfiguration.getBoolean(path);
        }

        public int getInt(String path) {
            return fileConfiguration.getInt(path);
        }

        public List<String> getStringList(String path) {
            if (fileConfiguration.isList(path))
                return fileConfiguration.getStringList(path);
            return new ArrayList<>();
        }

        public ConfigurationSection getConfigurationSection(String path) {
            return fileConfiguration.getConfigurationSection(path);
        }

        public boolean isString(String path) {
            return fileConfiguration.isString(path);
        }

        public boolean isList(String path) {
            return fileConfiguration.isList(path);
        }

        public List<Map<?, ?>> getMapList(String path) {
            return fileConfiguration.getMapList(path);
        }

        public File getConfig() {
            return file;
        }

        public File getFile() {
            return file;
        }

        public void setValue(String path, Object value) {
            fileConfiguration.set(path, value);
        }

        //PROCCESSING
        private void load() {
            if (!file.exists()) {
                Zray.getInstance().saveResource(fileName, false);
                try {
                    fileConfiguration.load(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    fileConfiguration.load(file);
                    final InputStream in = Zray.getInstance().getResource(fileName);
                    if (in != null) {
                        fileConfiguration.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(in)));
                        fileConfiguration.options().copyDefaults(true);
                        in.close();
                    }
                    fileConfiguration.save(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
