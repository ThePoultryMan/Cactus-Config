package io.github.thepoultryman.testmod.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.text.LiteralText;

public class TestConfigManager extends ConfigManager {
    public OptionHolder basic = new OptionHolder(new LiteralText("hey"), null);
    private boolean aBoolean;
    private boolean aSecondBoolean;
    private boolean anotherBoolean;

    public TestConfigManager(String fileName) {
        super(fileName);
    }

    @Override
    public void loadConfig() {
        super.loadConfig();

        this.getAndCreateBooleanOption(basic, "basic.a_boolean", true, this::getaBoolean, this::setaBoolean);
        this.getAndCreateBooleanOption(basic, "basic.a_second_boolean", false, this::getASecondBoolean, this::setASecondBoolean);
        this.basic.addSpruceSeparator("basic.wow_a_separator", true, true);
        this.getAndCreateBooleanOption(basic, "basic.another_boolean", true, this::getAnotherBoolean, this::setAnotherBoolean);
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

    public boolean getAnotherBoolean() {
        return this.anotherBoolean;
    }

    public void setAnotherBoolean(boolean b) {
        this.anotherBoolean = b;
        this.setConfigOption("basic.another_boolean", b);
    }
}
