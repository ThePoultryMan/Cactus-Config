package io.github.thepoultryman.cactusconfig;

import dev.lambdaurora.spruceui.option.SpruceOption;
import dev.lambdaurora.spruceui.option.SpruceToggleBooleanOption;
import net.minecraft.text.TranslatableText;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionHolder {
    public final List<SpruceOption> spruceOptions = new ArrayList<>();

    public void addSpruceToggleOption(String optionName, Supplier<Boolean> getMethod, Consumer<Boolean> setMethod) {
        this.spruceOptions.add(new SpruceToggleBooleanOption("cactus_config.option." + optionName, getMethod, setMethod,
                new TranslatableText("cactus_config.option.desc." + optionName)));
    }
}
