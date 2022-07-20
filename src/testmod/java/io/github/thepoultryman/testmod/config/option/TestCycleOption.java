package io.github.thepoultryman.testmod.config.option;

public enum TestCycleOption {
    ONE,
    TWO,
    ANOTHER_ONE,
    WHY;

    public TestCycleOption next() {
        if (values().length == this.ordinal() + 1) {
            return values()[0];
        } else {
            return values()[this.ordinal() + 1];
        }
    }
}
