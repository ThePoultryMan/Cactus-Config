package io.github.thepoultryman.cactusconfig.screen;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ScreenCustomizer {
    private Text title;
    private boolean oneOptionColumn = false;

    public ScreenCustomizer(Text title) {
        this.title = title;
        this.formatTitle(Formatting.WHITE);
    }

    public Text getTitle() {
        return this.title;
    }

    public void formatTitle(Formatting... formattings) {
        this.title = this.title.copy().formatted(formattings);
    }

    public boolean shouldUseOneOptionColumn() {
        return this.oneOptionColumn;
    }

    public void useOneOptionColumn() {
        this.oneOptionColumn = true;
    }
}
