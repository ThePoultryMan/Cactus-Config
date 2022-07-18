package com.github.thepoultryman.cactusconfig;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CactusConfig implements ModInitializer {
	public static final String MOD_ID = "cactusconfig";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Cactus Config is being initialized.");
	}
}
