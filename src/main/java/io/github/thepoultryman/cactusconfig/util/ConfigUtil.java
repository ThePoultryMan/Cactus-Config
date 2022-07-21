package io.github.thepoultryman.cactusconfig.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ConfigUtil {
    public static Item getItemFromIdentifier(String identifier) {
        return Registry.ITEM.get(new Identifier(identifier));
    }

    public static Item getItemFromIdentifier(Identifier identifier) {
        return Registry.ITEM.get(identifier);
    }

    public static ItemStack getItemStack(String identifier, String count) {
        Integer itemCount = CactusUtil.tryIntegerParse(count);
        return new ItemStack(getItemFromIdentifier(identifier), itemCount != null ? itemCount : 1);
    }

    public static ItemStack getItemStack(Identifier identifier, String count) {
        Integer itemCount = CactusUtil.tryIntegerParse(count);
        return new ItemStack(getItemFromIdentifier(identifier), itemCount != null ? itemCount : 1);
    }

    public static Text getCycleOptionText(String optionPath, Enum<?> cycleOptions) {
        return Text.translatable("cactus_config.option." + optionPath + "." + cycleOptions.name());
    }

    public static boolean isServerEnvironment() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER;
    }

    public static boolean isServerEnvironment() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER;
    }
}
