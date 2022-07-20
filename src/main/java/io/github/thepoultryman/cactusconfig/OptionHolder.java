package io.github.thepoultryman.cactusconfig;

import dev.lambdaurora.spruceui.option.*;
import io.github.thepoultryman.cactusconfig.util.ConfigUtil;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
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
        this.spruceOptions.add(new SpruceSeparatorOption("cactus_config.title_separator", false, null));
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
     *                   won't be displayed.
     */
    public void addSpruceToggleOption(String optionName, Supplier<Boolean> getMethod, Consumer<Boolean> setMethod, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceToggleBooleanOption("cactus_config.option." + optionName, getMethod, setMethod,
                hasTooltip ? new TranslatableText("cactus_config.option.desc." + optionName) : null));
    }

    /**
     * <p>Adds a {@link SpruceStringOption} based on the parameters passed
     * into the method. {@code optionName} determines the translation keys
     * for both the name and description of the option. For {@code getMethod}
     * and {@code setMethod}, you're going to want to use methods that you
     * have created for your config. If you don't want your option to have
     * a description (tooltip), you can set {@code hasTooltip} to false.</p>
     * <p>If you want to use a custom predicate instead of it always being
     * true, then you should use the overloaded method that takes the predicate.</p>
     * @param optionName The name of the option that will be added. This
     *                   name will be the suffix to "cactus_config.option."
     *                   and "cactus_config.option.desc." for the translation
     *                   keys of the name and description, respectively.
     * @param getMethod A {@link Supplier<String>} used to get the current
     *                  value of the option.
     * @param setMethod A {@link Consumer<String>} used to set the value
     *                  of the option.
     * @param hasTooltip If set to true, a tooltip containing the description
     *                   will be displayed. If set to false, this tooltip
     *                   won't be displayed.
     */
    public void addSpruceStringOption(String optionName, Supplier<String> getMethod, Consumer<String> setMethod, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceStringOption("cactus_config.option." + optionName, getMethod, setMethod, (s) -> true,
                hasTooltip ? new TranslatableText("cactus_config.option.desc." + optionName) : null));
    }

    /**
     * <p>Adds a {@link SpruceStringOption} based on the parameters passed
     * into the method. {@code optionName} determines the translation keys
     * for both the name and description of the option. For {@code getMethod}
     * and {@code setMethod}, you're going to want to use methods that you
     * have created for your config. If you don't want your option to have
     * a description (tooltip), you can set {@code hasTooltip} to false.</p>
     * <p>If you don't want to use a custom predicate instead of it always
     * being true, then you should use the base method that doesn't take a
     * predicate.</p>
     * @param optionName The name of the option that will be added. This
     *                   name will be the suffix to "cactus_config.option."
     *                   and "cactus_config.option.desc." for the translation
     *                   keys of the name and description, respectively.
     * @param getMethod A {@link Supplier<String>} used to get the current
     *                  value of the option.
     * @param setMethod A {@link Consumer<String>} used to set the value
     *                  of the option.
     * @param hasTooltip If set to true, a tooltip containing the description
     *                   will be displayed. If set to false, this tooltip
     *                   won't be displayed.
     * @param predicate A predicate that will determine if the text in the
     *                  field is valid.
     */
    public void addSpruceStringOption(String optionName, Supplier<String> getMethod, Consumer<String> setMethod, boolean hasTooltip, Predicate<String> predicate) {
        this.spruceOptions.add(new SpruceStringOption("cactus_config.option." + optionName, getMethod, setMethod, predicate,
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
     *                   won't be displayed.
     */
    public void addSpruceIntegerOption(String optionName, Supplier<Integer> getMethod, Consumer<Integer> setMethod, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceIntegerInputOption("cactus_config.option." + optionName, getMethod, setMethod,
                hasTooltip ? new TranslatableText("cactus_config.option.desc." + optionName) : null));
    }

    /**
     * <p>Adds a {@link SpruceFloatInputOption} based on the parameters
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
     * @param getMethod A {@link Supplier<Float>} used to get the current
     *                  value of the option.
     * @param setMethod A {@link Consumer<Float>} used to set the value
     *                  of the option.
     * @param hasTooltip If set to true, a tooltip containing the description
     *                   will be displayed. If set to false, this tooltip
     *                   won't be displayed.
     */
    public void addSpruceFloatOption(String optionName, Supplier<Float> getMethod, Consumer<Float> setMethod, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceFloatInputOption("cactus_config.option." + optionName, getMethod, setMethod,
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
     * @param getMethod A {@link Supplier<Double>} used to get the current
     *                  value of the option.
     * @param setMethod A {@link Consumer<Double>} used to set the value
     *                  of the option.
     * @param hasTooltip If set to true, a tooltip containing the description
     *                   will be displayed. If set to false, this tooltip
     *                   won't be displayed.
     */
    public void addSpruceDoubleOption(String optionName, Supplier<Double> getMethod, Consumer<Double> setMethod, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceDoubleInputOption("cactus_config.option." + optionName, getMethod, setMethod,
                hasTooltip ? new TranslatableText("cactus_config.option.desc." + optionName) : null));
    }

    /**
     * <p>Adds a {@link SpruceDoubleOption} based on the parameters passed
     * into the method. {@code optionName} determines the translation keys
     * for both the name and description of the option. For {@code getMethod}
     * and {@code setMethod}, you're going to want to use methods that you
     * have created for your config. If you don't want your option to have
     * a descriptions (tooltip), you can set {@code hasTooltip} to false.
     * The created slider will have a minimum and maximum based on the
     * {@code min} and {@code max} parameters, respectively. The slider
     * will move in steps the size of the {@code step} parameter.</p>
     * @param optionName The name of the option that will be added. This
     *                   name will be the suffix to "cactus_config.option."
     *                   and "cactus_config.option.desc." for the translation
     *                   keys of the name and description, respectively.
     * @param min The minimum value that the slider will go down to.
     * @param max The maximum value that the slider will go to.
     * @param step How much the value will increase or decrease each time
     *             you take a 'step' on the slider.
     * @param getMethod A {@link Supplier<Double>} used to get the current
     *                  value of the option.
     * @param setMethod A {@link Consumer<Double>} used to set the value
     *                  of the option.
     * @param hasTooltip If set to true, a tooltip containing the description
     *                   will be displayed. If set to false, this tooltip
     *                   won't be displayed.
     */
    public void addSpruceSliderOption(String optionName, double min, double max, float step, Supplier<Double> getMethod, Consumer<Double> setMethod, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceDoubleOption("cactus_config.option." + optionName, min, max, step, getMethod, setMethod,
                (option) -> option.getDisplayText(new LiteralText(String.valueOf(getMethod.get()))),
                hasTooltip ? new TranslatableText("cactus_config.option.desc." + optionName) : null));
    }

    public <T extends Enum<?>> void addSpruceCycleOption(String optionName, Supplier<T> getMethod, Consumer<Integer> setMethod, boolean hasTooltip) {
        this.spruceOptions.add(new SpruceCyclingOption("cactus_config.option." + optionName, setMethod,
                (option) -> option.getDisplayText(ConfigUtil.getCycleOptionText(optionName, getMethod.get())),
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
        return this.description == null ? null : this.description.shallowCopy().formatted(Formatting.GRAY);
    }
}
