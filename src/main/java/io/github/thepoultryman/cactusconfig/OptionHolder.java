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

    /**
     * The constructor used to initialize an {@link OptionHolder} object.
     * The title must be passed in, but the description is {@link Nullable},
     * making it optional.
     * @param title A {@link Text} object used to set the title of the tab,
     *              when it's added to the config screen.
     * @param description A {@link Nullable} {@link Text} object used to
     *                    set the description of the tab, when added to the
     *                    config screen.
     */
    public OptionHolder(Text title, @Nullable Text description) {
        this.title = title;
        this.description = description;
    }

    /**
     * <p>Adds a {@link SpruceToggleBooleanOption} based on the parameters passed into
     * the method. {@code optionName} determines the translation keys for
     * both the name and description of the option. For {@code getMethod}
     * and {@code setMethod}, you're going to want to use methods that you
     * have created for your config.</p>
     * @param optionName The name of the option that will be added. This
     *                   name will be the suffix to "cactus_config.option."
     *                   and "cactus_config.option.desc." for the translation
     *                   keys of the name and description, respectively.
     * @param getMethod A {@link Supplier<Boolean>} used to get the current
     *                  value of the option.
     * @param setMethod A {@link Consumer<Boolean>} used to set the value
     *                  of the option.
     */
    public void addSpruceToggleOption(String optionName, Supplier<Boolean> getMethod, Consumer<Boolean> setMethod) {
        this.spruceOptions.add(new SpruceToggleBooleanOption("cactus_config.option." + optionName, getMethod, setMethod,
                new TranslatableText("cactus_config.option.desc." + optionName)));
    }

    /**
     * <p>Gets the title, as {@link Text}, that was set in the constructor.</p>
     * @return The title set in the constructor, as {@link Text}.
     */
    public Text getTitle() {
        return this.title;
    }

    /**
     * <p>Gets the description, as {@link Text}, that was set in the
     * constructor.</p>
     * @return The description set in the constructor, as {@link Text}.
     */
    public Text getDescription() {
        return this.description;
    }
}
