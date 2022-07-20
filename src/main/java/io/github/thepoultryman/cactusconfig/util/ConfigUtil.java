package io.github.thepoultryman.cactusconfig.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
}
