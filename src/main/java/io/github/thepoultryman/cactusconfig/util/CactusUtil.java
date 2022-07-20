package io.github.thepoultryman.cactusconfig.util;

import io.github.thepoultryman.cactusconfig.CactusConfig;

public final class CactusUtil {
    public static Integer tryIntegerParse(String integer) {
        try {
            return Integer.valueOf(integer);
        } catch (NumberFormatException exception) {
            CactusConfig.LOGGER.warn("A mod using Cactus Config tried to parse an Integer but it failed! This could cause unforeseen issues (like crashes).", exception);
            return null;
        }
    }
}
