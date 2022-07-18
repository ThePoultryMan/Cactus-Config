package io.github.thepoultryman.cactusconfig.screen;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.widget.container.tabbed.SpruceTabbedWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public abstract class ConfigScreen extends SpruceScreen {
    private final Screen parent;

    public ConfigScreen(Text title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    protected void init() {
        super.init();

        SpruceTabbedWidget tabs = new SpruceTabbedWidget(Position.origin(), this.width, this.height, this.getConfigScreenTitle());
    }

    /**
     * The return value of this determines the name of the {@code SpruceTabWidget}.
     * @return The translatable text used to get the title.
     */
    public abstract TranslatableText getConfigScreenTitle();
}
