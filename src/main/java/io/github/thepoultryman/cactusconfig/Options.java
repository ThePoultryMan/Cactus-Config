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
    public @interface Boolean {
        boolean tooltip() default false;
        String tab() default "options";
        boolean defaultValue() default true;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Integer {
        boolean tooltip() default false;
        String tab() default "options";
        int defaultValue() default 0;
    }
}
