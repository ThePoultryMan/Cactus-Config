package io.github.thepoultryman.cactusconfig.mod;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.text.TranslatableText;

public class CactusConfigManager extends ConfigManager {
    public final OptionHolder general = new OptionHolder(new TranslatableText("cactus_config.mod.tabs.general"),
            new TranslatableText("cactus_config.mod.tabs.desc.general"));
    private boolean skipResetConfirmation;

    public CactusConfigManager(String fileName) {
        super(fileName);
    }

    @Override
    public void loadConfig() {
        super.loadConfig();

        this.getAndCreateBooleanOption(general, "mod.general.skip_reset_confirmation", false,
                () -> this.skipResetConfirmation, b -> this.skipResetConfirmation = b, true);
    }

    @Override
    public boolean canReset() {
        return true;
    }
}
