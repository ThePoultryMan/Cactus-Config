package io.github.thepoultryman.testmod.config.screen;

import io.github.thepoultryman.cactusconfig.OptionHolder;
import io.github.thepoultryman.cactusconfig.screen.ConfigScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

public class TestConfigScreen extends ConfigScreen {
    public TestConfigScreen(Screen parent, OptionHolder... optionHolders) {
        super(new LiteralText("hate"), parent, optionHolders);
    }

    @Override
    public TranslatableText getConfigScreenTitle() {
        return new TranslatableText("config.testmod.tabs_title");
    }
}
