package io.github.thepoultryman.cactusconfig.mod;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.text.Text;
public class CactusConfigManager extends ConfigManager {
    public final OptionHolder general = new OptionHolder(Text.translatable("cactus_config.mod.tabs.general"),
            Text.translatable("cactus_config.mod.tabs.desc.general"));
    public boolean skipResetConfirmation;

    public CactusConfigManager(String fileName) {
        super(fileName, false);
    }

    @Override
    protected void load() {
        this.getAndCreateBooleanOption(general, "mod.general.skip_reset_confirmation", false,
                () -> this.skipResetConfirmation, this::setSkipResetConfirmation, true);
    }

    @Override
    public boolean canReset() {
        return true;
    }

    private void setSkipResetConfirmation(boolean skipConfirmation) {
        this.skipResetConfirmation = skipConfirmation;
        this.setConfigOption("mod.general.skip_reset_confirmation", skipConfirmation);
    }
}
