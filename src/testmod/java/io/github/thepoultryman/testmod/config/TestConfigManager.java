package io.github.thepoultryman.testmod.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.text.LiteralText;

public class TestConfigManager extends ConfigManager {
    public OptionHolder basic = new OptionHolder(new LiteralText("hey"), null);
    private boolean aBoolean;

    public TestConfigManager(String fileName) {
        super(fileName);
    }

    @Override
    public void loadConfig() {
        super.loadConfig();

        this.getAndSetBooleanOption(basic, "basic.a_boolean", true, this::getaBoolean, this::setaBoolean);
    }

    public boolean getaBoolean() {
        return this.aBoolean;
    }

    public void setaBoolean(boolean b) {
        this.aBoolean = b;
    }
}
