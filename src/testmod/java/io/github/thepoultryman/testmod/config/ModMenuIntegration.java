package io.github.thepoultryman.testmod.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.thepoultryman.cactusconfig.screen.ConfigScreen;
import io.github.thepoultryman.testmod.TestMod;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (ConfigScreenFactory<Screen>) parent -> new ConfigScreen(new LiteralText("Testmod Config Screen"), parent, TestMod.testConfigManager.basic);
    }
}
