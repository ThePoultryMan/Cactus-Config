package io.github.thepoultryman.cactusconfig;

import com.electronwill.nightconfig.core.file.FileConfig;
import io.github.thepoultryman.cactusconfig.util.ConfigUtil;
import net.fabricmc.loader.api.FabricLoader;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class ConfigManager {
    public final String fileName;
    public FileConfig config = null;
    public final boolean loadOnServer;

    /**
     * <p>When creating the "template" TOML file, make sure that you put it
     * directly in the resources folder, unless you're using a sub-folder.
     * If you're using a sub-folder, both the config directory and the
     * resources folder need to respect that.</p>
     * @param fileName The name that the config file will use. Should omit
     *                 the '.toml' at the end. To put the file within a
     *                 sub-folder, use forward slashes.
     */
    public ConfigManager(String fileName, boolean loadOnServer) {
        this.fileName = fileName;
        this.loadOnServer = loadOnServer;
        if (!ConfigUtil.isServerEnvironment()) {
            this.config = this.buildFileConfig();
        } else if (ConfigUtil.isServerEnvironment() && this.loadOnServer) {
            this.config = this.buildFileConfig();
        }
    }

    private FileConfig buildFileConfig() {
        return FileConfig.builder(FabricLoader.getInstance().getConfigDir() + "/" + this.fileName + ".toml")
                .defaultResource("/" + this.fileName + ".toml").build();
    }

    public void loadConfig() {
        if (this.config != null) {
            this.load();
        }
    }

    protected abstract void load();

    public abstract boolean canReset();

    public void reset() {}

    /**
     * <p>Adds a new toggle switch option to the {@code optionHolder} provided.</p>
     * @param optionHolder The {@link OptionHolder} that you want the toggle
     *                     to be added to. Remember: {@link OptionHolder}'s
     *                     correspond to the tab that the option will be
     *                     added to.
     * @param path The path to the key within the TOML file you want to
     *             correspond with this option.
     * @param defaultValue The value that the key will default to if it
     *                     cannot be found.
     * @param getter The method that will be used to get the value of this
     *               option.
     * @param setter The method that will be used to set the value of this
     *               option.
     */
    public void getAndCreateBooleanOption(OptionHolder optionHolder, String path, boolean defaultValue, Supplier<Boolean> getter, Consumer<Boolean> setter, boolean hasTooltip) {
        boolean value = this.config.getOrElse(path, defaultValue);
        setter.accept(value);
        optionHolder.addSpruceToggleOption(path, getter, setter, hasTooltip);
    }

    /**
     * <p>Adds a new string (text) field to the {@code optionHolder} provided.</p>
     * <p>If you want to use a custom predicate instead of it always being
     * true, then you should use the overloaded method that takes the predicate.</p>
     * @param optionHolder The {@link OptionHolder} that you want the field
     *                     to be added to. Remember: {@link OptionHolder}'s
     *                     correspond to the tab that the option will be
     *                     added to.
     * @param path The path to the key within the TOML file you want to
     *             correspond with this option.
     * @param defaultValue The value that the key will default to if it
     *                     cannot be found.
     * @param getter The method that will be used to get the value of this
     *               option.
     * @param setter The method that will be used to set the value of this
     *               option.
     */
    public void getAndCreateStringOption(OptionHolder optionHolder, String path, String defaultValue, Supplier<String> getter, Consumer<String> setter, boolean hasTooltip) {
        String value = this.config.getOrElse(path, defaultValue);
        setter.accept(value);
        optionHolder.addSpruceStringOption(path, getter, setter, hasTooltip);
    }

    /**
     * <p>Adds a new string (text) field to the {@code optionHolder} provided.</p>
     * <p>If you don't want to use a custom predicate instead of it always
     * being true, then you should use the base method that doesn't take a
     * predicate.</p>
     * @param optionHolder The {@link OptionHolder} that you want the field
     *                     to be added to. Remember: {@link OptionHolder}'s
     *                     correspond to the tab that the option will be
     *                     added to.
     * @param path The path to the key within the TOML file you want to
     *             correspond with this option.
     * @param defaultValue The value that the key will default to if it
     *                     cannot be found.
     * @param getter The method that will be used to get the value of this
     *               option.
     * @param setter The method that will be used to set the value of this
     *               option.
     * @param predicate A predicate that will determine if the text in the
     *                  field is valid.
     */
    public void getAndCreateStringOption(OptionHolder optionHolder, String path, String defaultValue, Supplier<String> getter, Consumer<String> setter, boolean hasTooltip, Predicate<String> predicate) {
        String value = this.config.getOrElse(path, defaultValue);
        setter.accept(value);
        optionHolder.addSpruceStringOption(path, getter, setter, hasTooltip, predicate);
    }

    /**
     * <p>Adds a new integer input field to the {@code optionHolder} provided.</p>
     * @param optionHolder The {@link OptionHolder} that you want the field
     *                     to be added to. Remember: {@link OptionHolder}'s
     *                     correspond to the tab that the option will be
     *                     added to.
     * @param path The path to the key within the TOML file you want to
     *             correspond with this option.
     * @param defaultValue The value that the key will default to if it
     *                     cannot be found.
     * @param getter The method that will be used to get the value of this
     *               option.
     * @param setter The method that will be used to set the value of this
     *               option.
     */
    public void getAndCreateIntegerOption(OptionHolder optionHolder, String path, int defaultValue, Supplier<Integer> getter, Consumer<Integer> setter, boolean hasTooltip) {
        int value = this.config.getOrElse(path, defaultValue);
        setter.accept(value);
        optionHolder.addSpruceIntegerOption(path, getter, setter, hasTooltip);
    }

    /**
     * <p>Adds a new float input field to the {@code optionHolder} provided.</p>
     * @param optionHolder The {@link OptionHolder} that you want the field
     *                     to be added to. Remember: {@link OptionHolder}'s
     *                     correspond to the tab that the option will be
     *                     added to.
     * @param path The path to the key within the TOML file you want to
     *             correspond with this option.
     * @param defaultValue The value that the key will default to if it
     *                     cannot be found.
     * @param getter The method that will be used to get the value of this
     *               option.
     * @param setter The method that will be used to set the value of this
     *               option.
     */
    public void getAndCreateFloatOption(OptionHolder optionHolder, String path, double defaultValue, Supplier<Float> getter, Consumer<Float> setter, boolean hasTooltip) {
        double value = this.config.getOrElse(path, defaultValue);
        setter.accept((float) value);
        optionHolder.addSpruceFloatOption(path, getter, setter, hasTooltip);
    }

    /**
     * <p>Adds a new double input field to the {@code optionHolder} provided.</p>
     * @param optionHolder The {@link OptionHolder} that you want the field
     *                     to be added to. Remember: {@link OptionHolder}'s
     *                     correspond to the tab that the option will be
     *                     added to.
     * @param path The path to the key within the TOML file you want to
     *             correspond with this option.
     * @param defaultValue The value that the key will default to if it
     *                     cannot be found.
     * @param getter The method that will be used to get the value of this
     *               option.
     * @param setter The method that will be used to set the value of this
     *               option.
     */
    public void getAndCreateDoubleOption(OptionHolder optionHolder, String path, double defaultValue, Supplier<Double> getter, Consumer<Double> setter, boolean hasTooltip) {
        double value = this.config.getOrElse(path, defaultValue);
        setter.accept(value);
        optionHolder.addSpruceDoubleOption(path, getter, setter, hasTooltip);
    }

    /**
     * <p>Adds a new slider to the {@code optionHolder} provided.</p>
     * @param optionHolder The {@link OptionHolder} that you want the field
     *                     to be added to. Remember: {@link OptionHolder}'s
     *                     correspond to the tab that the option will be
     *                     added to.
     * @param path The path to the key within the TOML file you want to
     *             correspond with this option.
     * @param defaultValue The value that the key will default to if it
     *                     cannot be found.
     * @param min The minimum value that the slider will
     * @param max The maximum value that the slider will
     * @param step How much the value will increase or decrease each time
     *             you take a 'step' on the slider.
     * @param getter The method that will be used to get the value of this
     *               option.
     * @param setter The method that will be used to set the value of this
     *               option.
     */
    public void getAndCreateSliderOption(OptionHolder optionHolder, String path, double defaultValue, double min, double max, float step, Supplier<Double> getter, Consumer<Double> setter, boolean hasTooltip) {
        double value = this.config.getOrElse(path, defaultValue);
        setter.accept(value);
        optionHolder.addSpruceSliderOption(path, min, max, step, getter, setter, hasTooltip);
    }

    public <T extends Enum<?>> void getAndCreateCycleOption(OptionHolder optionHolder, String path, T defaultValue, Supplier<T> getter, Consumer<T> setter, Consumer<Integer> cycleMethod, boolean hasTooltip) {
        T value = this.config.getOrElse(path, defaultValue);
        setter.accept(value);
        optionHolder.addSpruceCycleOption(path, getter, cycleMethod, hasTooltip);
    }

    /**
     * <p>Sets the value of the key at the end of the specified path.
     * After the key has been set the file will be saved.</p>
     * <p>If the path does not exist, then a new key will be created,
     * and it will be set to the {@code optionValue}</p>
     * <p><b>Adding more values.</b></p>
     * <p>Because of the way that keys are added and gotten, all you
     * need to do to add a new key is add another option. New keys
     * should not be treated any differently from old keys.</p>
     * @param optionPath The path of the key that will be set.
     * @param optionValue The value that the key will be set to.
     */
    public void setConfigOption(String optionPath, Object optionValue) {
        this.config.set(optionPath, optionValue);
        this.config.save();
    }

    /**
     * <p>Gets the config value from the TOML file from the path provided.
     * If the path cannot be found, a new key is added to the TOML
     * file. This new key has the value of the {@code defaultValue}
     * parameter.</p>
     * @param optionPath The path to the key in the TOML file.
     * @param defaultValue The default value of the wanted key. This
     *                     will be used if the path does not exist.
     * @return The value of the wanted key ({@code optionPath}), or the
     * value of the newly created key ({@code defaultValue}).
     */
    public <T> T getConfigOption(String optionPath, T defaultValue) {
        if (this.config.contains(optionPath)) {
            return this.config.get(optionPath);
        } else {
            T obj = this.config.set(optionPath, defaultValue);
            this.config.save();
            return obj;
        }
    }
}
