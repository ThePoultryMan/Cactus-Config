package io.github.thepoultryman.testmod.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.text.LiteralText;

public class TestConfigManager extends ConfigManager {
    public OptionHolder basic = new OptionHolder(new LiteralText("hey"), null);
    private boolean aBoolean;
    private boolean aSecondBoolean;

    public TestConfigManager(String fileName) {
        super(fileName);
    }

    @Override
    public void loadConfig() {
        super.loadConfig();

        this.getAndCreateBooleanOption(basic, "basic.a_boolean", true, this::getaBoolean, this::setaBoolean);
        this.getAndCreateBooleanOption(basic, "basic.a_second_boolean", false, this::getASecondBoolean, this::setASecondBoolean);
    }

    public boolean getaBoolean() {
        return this.aBoolean;
    }

    public void setaBoolean(boolean b) {
        this.aBoolean = b;
        this.setConfigOption("basic.a_boolean", b);
    }

    public boolean getASecondBoolean() {
        return this.aSecondBoolean;
    }

    public void setASecondBoolean(boolean b) {
        this.aSecondBoolean = b;
        this.setConfigOption("basic.a_second_boolean", b);
    }
}
