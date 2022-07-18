package io.github.thepoultryman.cactusconfig;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.fabricmc.loader.api.FabricLoader;

public abstract class ConfigManager {
    public final String fileName;
    public final FileConfig config;

    public ConfigManager(String fileName) {
        this.fileName = fileName;
        this.config = FileConfig.builder(FabricLoader.getInstance().getConfigDir() + "/" + this.fileName + ".toml")
                .defaultResource("/" + this.fileName + ".toml").autosave().build();
    }

    public void loadConfig() {
        this.config.load();
    }
}
