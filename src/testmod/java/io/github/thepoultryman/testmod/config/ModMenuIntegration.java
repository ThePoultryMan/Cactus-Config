package io.github.thepoultryman.testmod.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.thepoultryman.cactusconfig.screen.ConfigScreen;
import io.github.thepoultryman.cactusconfig.screen.ScreenCustomizer;
import io.github.thepoultryman.testmod.TestMod;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        ScreenCustomizer screenCustomizer = new ScreenCustomizer(Text.literal("Testmod Config Screen"));
        //screenCustomizer.useOneOptionColumn();

        return (ConfigScreenFactory<Screen>) parent -> new ConfigScreen(screenCustomizer,
                parent, TestMod.testConfigManager, TestMod.testConfigManager.getOptionHolders());
    }
}
