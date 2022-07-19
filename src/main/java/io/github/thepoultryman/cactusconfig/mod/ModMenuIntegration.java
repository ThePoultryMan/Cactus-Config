package io.github.thepoultryman.cactusconfig.mod;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.thepoultryman.cactusconfig.CactusConfig;
import io.github.thepoultryman.cactusconfig.screen.ConfigScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (ConfigScreenFactory<Screen>) parent -> new ConfigScreen(new TranslatableText("cactus_config.mod.config_title"), parent,
                CactusConfig.CACTUS_CONFIG_MANAGER, CactusConfig.CACTUS_CONFIG_MANAGER.general);
    }
}
