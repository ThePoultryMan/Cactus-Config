package io.github.thepoultryman.cactusconfig;

import dev.lambdaurora.spruceui.option.SpruceIntegerInputOption;
import dev.lambdaurora.spruceui.option.SpruceOption;
import dev.lambdaurora.spruceui.option.SpruceSeparatorOption;
import dev.lambdaurora.spruceui.option.SpruceToggleBooleanOption;
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
     * <p>Adds a {@link SpruceToggleBooleanOption} based on the parameters
     * passed into the method. {@code optionName} determines the translation
     * keys for both the name and description of the option. For
     * {@code getMethod} and {@code setMethod}, you're going to want to use
     * methods that you have created for your config. If you don't want
     * your option to have a description (tooltip), you can set {@code hasTooltip}
     * to false.</p>
     * @param optionName The name of the option that will be added. This
     *                   name will be the suffix to "cactus_config.option."
     *                   and "cactus_config.option.desc." for the translation
     *                   keys of the name and description, respectively.
     * @param getMethod A {@link Supplier<Boolean>} used to get the current
     *                  value of the option.
     * @param setMethod A {@link Consumer<Boolean>} used to set the value
     *                  of the option.
     * @param hasTooltip If set to true, a tooltip containing the description
     *                   will be displayed. If set to false, this tooltip
     *                   won't exist
     */
    public void addSpruceToggleOption(String optionName, Supplier<Boolean> getMethod, Consumer<Boolean> setMethod, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceToggleBooleanOption("cactus_config.option." + optionName, getMethod, setMethod,
                hasTooltip ? new TranslatableText("cactus_config.option.desc." + optionName) : null));
    }

    /**
     * <p>Adds a {@link SpruceIntegerInputOption} based on the parameters
     * passed into the method. {@code optionName} determines the translation
     * keys for both the name and description of the option. For
     * {@code getMethod} and {@code setMethod}, you're going to want to use
     * methods that you have created for your config. If you don't want
     * your option to have a description (tooltip), you can set {@code hasTooltip}
     * to false.</p>
     * @param optionName The name of the option that will be added. This
     *                   name will be the suffix to "cactus_config.option."
     *                   and "cactus_config.option.desc." for the translation
     *                   keys of the name and description, respectively.
     * @param getMethod A {@link Supplier<Integer>} used to get the current
     *                  value of the option.
     * @param setMethod A {@link Consumer<Integer>} used to set the value
     *                  of the option.
     * @param hasTooltip If set to true, a tooltip containing the description
     *                   will be displayed. If set to false, this tooltip
     *                   won't exist
     */
    public void addSpruceIntegerOption(String optionName, Supplier<Integer> getMethod, Consumer<Integer> setMethod, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceIntegerInputOption("cactus_config.option." + optionName, getMethod, setMethod,
                hasTooltip ? new TranslatableText("cactus_config.option.desc." + optionName) : null));
    }

    /**
     * <p>Adds a separating line within the config screen. This line can
     * have a visible title within it, and can have a tooltip as well.</p>
     * <p>This option is order-dependent because it will appear in the order
     * that you add it. In example, adding it after 'optionA' but after
     * 'optionB' will get you the display order of 'optionA'->separator->'optionB.'</p>
     * @param separatorName Prefixed to "cactus_config.separator." for the
     *                      key, and this key is used to set the title of
     *                      the separator. Prefixed to "cactus_config.separator.tooltip."
     *                      to set the translation key for the tooltip. If
     *                      {@code hasTooltip} is false, then this key won't
     *                      need to be defined in the language file.
     * @param showTitle If set to true, the title of the separator, as
     *                  defined in the language file, will be displayed
     *                  inside the separator.
     * @param hasTooltip If set to true, the tooltip, as defined in the
     *                   language file, will be displayed. If set to false,
     *                   you don't need to specify the tooltip in the
     *                   language file.
     */
    public void addSpruceSeparator(String separatorName, boolean showTitle, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceSeparatorOption("cactus_config.separator." + separatorName, showTitle,
                hasTooltip ? new TranslatableText("cactus_config.separator.tooltip." + separatorName) : null));
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
