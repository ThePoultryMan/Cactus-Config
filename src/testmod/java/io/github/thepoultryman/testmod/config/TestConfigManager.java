package io.github.thepoultryman.testmod.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import io.github.thepoultryman.testmod.config.option.TestCycleOption;
import net.minecraft.text.LiteralText;

public class TestConfigManager extends ConfigManager {
    public OptionHolder basic = new OptionHolder(new LiteralText("hey"), null);
    private boolean aBoolean;
    private boolean aSecondBoolean;
    private boolean anotherBoolean;
    private TestCycleOption cycleOption;
    public OptionHolder numericTab = new OptionHolder(new LiteralText("Numeric Fields"), new LiteralText("A demo of all numeric fields"));
    private int superCoolInteger;
    private float superCoolFloat;
    private double averageDouble;
    private double slidingDouble;
    public OptionHolder tooManyStringsTab = new OptionHolder(new LiteralText("Too Many Strings"), new LiteralText("Way too many string fields"));
    private String firstString;

    public TestConfigManager(String fileName) {
        super(fileName);
    }

    @Override
    public void loadConfig() {
        super.loadConfig();

        this.basic.addSpruceSeparator("basic.a_test_separator", true, false);
        this.getAndCreateBooleanOption(basic, "basic.a_boolean", true, this::getaBoolean, this::setaBoolean, true);
        this.getAndCreateBooleanOption(basic, "basic.a_second_boolean", false, this::getASecondBoolean, this::setASecondBoolean, true);
        this.basic.addSpruceSeparator("basic.wow_a_separator", true, true);
        this.getAndCreateBooleanOption(basic, "basic.another_boolean", true, this::getAnotherBoolean, this::setAnotherBoolean, true);
        this.getAndCreateCycleOption(basic, "basic.test_enum", TestCycleOption.ONE,
                () -> this.cycleOption,
                (value) -> this.cycleOption = value,
                (amount) -> this.cycleOption = this.cycleOption.next(),true);

        this.getAndCreateIntegerOption(numericTab, "numeric.super_cool_integer", 1, this::getSuperCoolInteger, this::setSuperCoolInteger, true);
        this.getAndCreateFloatOption(numericTab, "numeric.super_cool_float", 57.8924D, this::getSuperCoolFloat, this::setSuperCoolFloat, true);
        this.numericTab.addSpruceSeparator("numeric.no_tooltip", true, true);
        this.getAndCreateDoubleOption(numericTab, "numeric.average_double", 23.2D, this::getAverageDouble, this::setAverageDouble, false);
        this.getAndCreateSliderOption(numericTab, "numeric.sliding_double", 120D, 30D, 240D, 1f, this::getSlidingDouble, this::setSlidingDouble, false);

        this.getAndCreateStringOption(tooManyStringsTab, "too_many_strings.first_string", "", this::getFirstString, this::setFirstString, true);
    }

    @Override
    public boolean canReset() {
        return true;
    }

    @Override
    public void reset() {
        this.setaBoolean(true);
        this.setASecondBoolean(false);
        this.setAnotherBoolean(true);
        this.setSuperCoolInteger(1);
        this.setSuperCoolFloat(57.8924f);
        this.setAverageDouble(23.2D);
        this.setSlidingDouble(120D);
        this.setFirstString("");
    }

    public boolean getaBoolean() {
        return this.aBoolean;
    }

    public void setaBoolean(boolean b) {
        this.aBoolean = b;
        this.setConfigOption("basic.a_boolean", b);
    }

    public boolean getASecondBoolean() {
        return this.aSecondBoolean;
    }

    public void setASecondBoolean(boolean b) {
        this.aSecondBoolean = b;
        this.setConfigOption("basic.a_second_boolean", b);
    }

    public boolean getAnotherBoolean() {
        return this.anotherBoolean;
    }

    public void setAnotherBoolean(boolean b) {
        this.anotherBoolean = b;
        this.setConfigOption("basic.another_boolean", b);
    }

    public int getSuperCoolInteger() {
        return this.superCoolInteger;
    }

    public void setSuperCoolInteger(int integer) {
        this.superCoolInteger = integer;
        this.setConfigOption("numeric.super_cool_integer", integer);
    }

    public float getSuperCoolFloat() {
        return this.superCoolFloat;
    }

    public void setSuperCoolFloat(float newFloat) {
        this.superCoolFloat = newFloat;
        this.setConfigOption("numeric.super_cool_float", newFloat);
    }

    public double getAverageDouble() {
        return this.averageDouble;
    }

    public void setAverageDouble(double avgDouble) {
        this.averageDouble = avgDouble;
        this.setConfigOption("numeric.average_double", avgDouble);
    }

    public double getSlidingDouble() {
        return this.slidingDouble;
    }

    public void setSlidingDouble(double slidDouble) {
        this.slidingDouble = slidDouble;
        this.setConfigOption("numeric.sliding_double", slidDouble);
    }

    public String getFirstString() {
        return this.firstString;
    }

    public void setFirstString(String string) {
        this.firstString = string;
        this.setConfigOption("too_many_strings.first_string", string);
    }
}
