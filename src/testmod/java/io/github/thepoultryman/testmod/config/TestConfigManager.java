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
    private boolean aSecondBoolean;
    private boolean anotherBoolean;
    private TestCycleOption cycleOption;
    @Options.OptionHolder
    public OptionHolder numeric = new OptionHolder(Text.literal("Numeric Fields"), Text.literal("A demo of all numeric fields"));
    @Options.Integer(tab = "numeric")
    private int superCoolInteger;
    @Options.Integer(tab = "numeric")
    private int lessCoolInteger;
    private float superCoolFloat;
    private double averageDouble;
    private double slidingDouble;

    @Options.OptionHolder
    public OptionHolder tooManyStrings = new OptionHolder(Text.literal("Too Many Strings"), Text.literal("Way too many string fields"));
    @Options.StringField(tab = "tooManyStrings")
    private String firstString;

    public TestConfigManager(String fileName, boolean loadOnServer) {
        super(fileName, loadOnServer);
    }

    @Override
    public void load() {
//        this.basic.addSpruceSeparator("basic.a_test_separator", true, false);
//        this.getAndCreateBooleanOption(basic, "basic.a_boolean", true, this::getaBoolean, this::setaBoolean, true);
//        this.getAndCreateBooleanOption(basic, "basic.a_second_boolean", false, this::getASecondBoolean, this::setASecondBoolean, true);
//        this.basic.addSpruceSeparator("basic.wow_a_separator", true, true);
//        this.getAndCreateBooleanOption(basic, "basic.another_boolean", true, this::getAnotherBoolean, this::setAnotherBoolean, true);
//        this.getAndCreateCycleOption(basic, "basic.test_enum", TestCycleOption.ONE,
//                () -> this.cycleOption,
//                (value) -> this.cycleOption = value,
//                (amount) -> this.cycleOption = this.cycleOption.next(),true);
//
//        //this.getAndCreateIntegerOption(numericTab, "numeric.super_cool_integer", 1, this::getSuperCoolInteger, this::setSuperCoolInteger, true);
//        this.getAndCreateFloatOption(numericTab, "numeric.super_cool_float", 57.8924D, this::getSuperCoolFloat, this::setSuperCoolFloat, true);
//        this.numericTab.addSpruceSeparator("numeric.no_tooltip", true, true);
//        this.getAndCreateDoubleOption(numericTab, "numeric.average_double", 23.2D, this::getAverageDouble, this::setAverageDouble, false);
//        this.getAndCreateSliderOption(numericTab, "numeric.sliding_double", 120D, 30D, 240D, 1f, this::getSlidingDouble, this::setSlidingDouble, false);
//
//        this.getAndCreateStringOption(tooManyStringsTab, "too_many_strings.first_string", "", this::getFirstString, this::setFirstString, true);
//
//        List<String> testOptions = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "hey", "yeah", "another", "one");
//        for (String testOption : testOptions) {
//            this.getAndCreateStringOption(tooManyStringsTab, "too_many_strings." + testOption, "none",
//                    () -> testString, (newValue) -> testString = newValue, false);
//        }
    }

    @Override
    public boolean canReset() {
        return true;
    }

    @Override
    public void reset() {
//        this.setaBoolean(true);
//        this.setASecondBoolean(false);
//        this.setAnotherBoolean(true);
//        this.setSuperCoolInteger(1);
//        this.setSuperCoolFloat(57.8924f);
//        this.setAverageDouble(23.2D);
//        this.setSlidingDouble(120D);
//        this.setFirstString("");
    }
}