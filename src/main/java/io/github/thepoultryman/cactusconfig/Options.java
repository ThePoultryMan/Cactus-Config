package io.github.thepoultryman.cactusconfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Options {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface OptionHolder {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Separator {
        String tab() default "options";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Boolean {
        boolean tooltip() default false;
        String tab() default "options";
        boolean defaultValue() default true;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface StringField {
        boolean tooltip() default false;
        String tab() default "options";
        String defaultValue() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Integer {
        boolean tooltip() default false;
        String tab() default "options";
        int defaultValue() default 0;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface FloatField {
        boolean tooltip() default false;
        String tab() default "options";
        float defaultValue() default 0.0f;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface DoubleField {
        boolean tooltip() default false;
        String tab() default "options";
        double defaultValue() default 0.0d;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Slider {
        boolean tooltip() default false;
        String tab() default "options";
        double defaultValue() default 0.0d;
        double min() default -10000.0d;
        double max() default 10000.0d;
        float step() default 1.0f;
    }
}
