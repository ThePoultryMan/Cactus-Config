package io.github.thepoultryman.cactusconfig;

import io.github.thepoultryman.cactusconfig.mod.CactusConfigManager;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CactusConfig implements ModInitializer {
	public static final String MOD_ID = "cactusconfig";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final CactusConfigManager CACTUS_CONFIG_MANAGER = new CactusConfigManager("cactus_config");

	@Override
	public void onInitialize() {
		LOGGER.info("Cactus Config is being initialized.");

		CACTUS_CONFIG_MANAGER.loadConfig();
	}
}
