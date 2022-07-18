package io.github.thepoultryman.cactusconfig;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.fabricmc.loader.api.FabricLoader;

import java.util.function.Consumer;
import java.util.function.Supplier;

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

    public void getAndSetBooleanOption(OptionHolder optionHolder, String path, boolean defaultValue, Supplier<Boolean> getter, Consumer<Boolean> setter) {
        boolean value = this.config.getOrElse(path, defaultValue);
        setter.accept(value);
        optionHolder.addSpruceToggleOption(path, getter, setter);
    }

    public void setConfigOption(String optionPath, Object optionValue) {
        this.config.set(optionPath, optionValue);
        this.config.save();
    }

    public Object getConfigOption(String optionPath, Object defaultValue) {
        if (this.config.contains(optionPath)) {
            return this.config.get(optionPath);
        } else {
            Object obj = this.config.set(optionPath, defaultValue);
            this.config.save();
            return obj;
        }
    }
}
