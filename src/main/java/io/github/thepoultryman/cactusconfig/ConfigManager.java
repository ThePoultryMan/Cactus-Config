package io.github.thepoultryman.cactusconfig;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.fabricmc.loader.api.FabricLoader;

public abstract class ConfigManager {
    public final String fileName;
    public final FileConfig config;

    public ConfigManager(String fileName) {
        this.fileName = fileName;
        this.config = FileConfig.builder(FabricLoader.getInstance().getConfigDir() + "/" + this.fileName + ".toml")
                .defaultResource("/" + this.fileName + ".toml").build();
    }

    public void loadConfig() {
        this.config.load();
    }

    public void setConfigOption(String optionPath, Object optionValue) {
        if (this.config.contains(optionPath)) {
            this.config.set(optionPath, optionValue);
            this.config.save();
        } else {
            CactusConfig.LOGGER.warn("The path '" + optionPath + "' does not exist, and therefore it cannot be set.");
        }
    }

    public Object getConfigOption(String optionPath) {
        if (this.config.contains(optionPath)) {
            return this.config.get(optionPath);
        } else {
            CactusConfig.LOGGER.warn("The path '" + optionPath + "' does not exist, and therefore it cannot be gotten.");
            return null;
        }
    }
}
