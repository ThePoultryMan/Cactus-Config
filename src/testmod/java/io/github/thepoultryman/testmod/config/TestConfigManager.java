package io.github.thepoultryman.testmod.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.text.LiteralText;

public class TestConfigManager extends ConfigManager {
    public OptionHolder basic = new OptionHolder(new LiteralText("hey"), null);
    private boolean aBoolean;
    private boolean aSecondBoolean;
    private boolean anotherBoolean;
    public OptionHolder numericTab = new OptionHolder(new LiteralText("Numeric Fields"), new LiteralText("A demo of all numeric fields"));
    private int superCoolInteger;
    private float superCoolFloat;
    private double averageDouble;

    public TestConfigManager(String fileName) {
        super(fileName);
    }

    @Override
    public void loadConfig() {
        super.loadConfig();

        this.getAndCreateBooleanOption(basic, "basic.a_boolean", true, this::getaBoolean, this::setaBoolean, true);
        this.getAndCreateBooleanOption(basic, "basic.a_second_boolean", false, this::getASecondBoolean, this::setASecondBoolean, true);
        this.basic.addSpruceSeparator("basic.wow_a_separator", true, true);
        this.getAndCreateBooleanOption(basic, "basic.another_boolean", true, this::getAnotherBoolean, this::setAnotherBoolean, true);

        this.getAndCreateIntegerOption(numericTab, "numeric.super_cool_integer", 1, this::getSuperCoolInteger, this::setSuperCoolInteger, true);
        this.getAndCreateFloatOption(numericTab, "numeric.super_cool_float", 57.8924D, this::getSuperCoolFloat, this::setSuperCoolFloat, true);
        this.numericTab.addSpruceSeparator("numeric.no_tooltip", true, true);
        this.getAndCreateDoubleOption(numericTab, "numeric.average_double", 23.2D, this::getAverageDouble, this::setAverageDouble, false);
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
}
