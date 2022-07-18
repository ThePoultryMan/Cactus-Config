package io.github.thepoultryman.testmod.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;

public class TestConfigManager extends ConfigManager {
    private boolean aBoolean;

    public TestConfigManager(String fileName) {
        super(fileName);
    }

    @Override
    public void loadConfig() {
        super.loadConfig();

        this.aBoolean = this.config.getOrElse("basic.a_boolean", false);
    }

    public boolean getaBoolean() {
        return this.aBoolean;
    }

    public void setaBoolean(boolean b) {
        this.aBoolean = b;
    }
}
