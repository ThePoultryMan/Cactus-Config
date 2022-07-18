package io.github.thepoultryman.cactusconfig;

import dev.lambdaurora.spruceui.option.SpruceOption;
import dev.lambdaurora.spruceui.option.SpruceToggleBooleanOption;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import io.github.thepoultryman.cactusconfig.screen.ConfigScreen;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionHolder {
    public final List<SpruceOption> spruceOptions = new ArrayList<>();
    private final Text title;
    private final Text description;

    public OptionHolder(Text title, @Nullable Text description) {
        this.title = title;
        this.description = description;
    }

    public void addSpruceToggleOption(String optionName, Supplier<Boolean> getMethod, Consumer<Boolean> setMethod) {
        this.spruceOptions.add(new SpruceToggleBooleanOption("cactus_config.option." + optionName, getMethod, setMethod,
                new TranslatableText("cactus_config.option.desc." + optionName)));
    }

    public Text getTitle() {
        return this.title;
    }

    public Text getDescription() {
        return this.description;
    }
}
