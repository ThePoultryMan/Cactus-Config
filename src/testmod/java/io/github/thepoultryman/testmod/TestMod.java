package io.github.thepoultryman.testmod;

import io.github.thepoultryman.testmod.config.TestConfigManager;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final TestConfigManager testConfigManager = new TestConfigManager("testmod", true);

	@Override
	public void onInitialize() {
		LOGGER.info("testmod is up and running.");

		testConfigManager.loadConfig();
	}
}
