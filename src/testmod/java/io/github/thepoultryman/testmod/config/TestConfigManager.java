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

        this.getAndSetBooleanOption(basic, "basic.a_boolean", true,
                () -> (boolean) this.getConfigOption("basic.a_boolean"),
                b -> this.setConfigOption("basic.a_boolean", b));
    }
}
