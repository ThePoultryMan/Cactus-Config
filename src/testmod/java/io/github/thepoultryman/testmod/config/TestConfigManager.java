package io.github.thepoultryman.testmod.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import io.github.thepoultryman.cactusconfig.Options;
import io.github.thepoultryman.testmod.config.option.TestCycleOption;
import net.minecraft.text.Text;

public class TestConfigManager extends ConfigManager {
    @Options.OptionHolder
    public OptionHolder basic = new OptionHolder(Text.literal("hey"), null);
    @Options.Boolean(tab = "basic")
    private boolean aBoolean;
    @Options.Boolean(tab = "basic")
    private boolean aSecondBoolean;
    @Options.Boolean(tab = "basic")
    private boolean anotherBoolean;
    private TestCycleOption cycleOption;
    @Options.OptionHolder
    public OptionHolder numeric = new OptionHolder(Text.literal("Numeric Fields"), Text.literal("A demo of all numeric fields"));
    @Options.Integer(tab = "numeric")
    private int superCoolInteger;
    @Options.Integer(tab = "numeric")
    private int lessCoolInteger;
    @Options.FloatField(tab = "numeric")
    private float superCoolFloat;
    @Options.DoubleField(tab = "numeric")
    private double averageDouble;
    @Options.Slider(tab = "numeric", max = 100, min = -200, step = 2.0f)
    private double slidingDouble;

    @Options.OptionHolder
    public OptionHolder tooManyStrings = new OptionHolder(Text.literal("Too Many Strings"), Text.literal("Way too many string fields"));
    @Options.StringField(tab = "tooManyStrings")
    private String firstString;

    public TestConfigManager(String fileName, boolean loadOnServer) {
        super(fileName, loadOnServer);
    }

    @Override
    public boolean canReset() {
        return true;
    }
}