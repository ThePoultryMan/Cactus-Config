package io.github.thepoultryman.cactusconfig.screen;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.option.SpruceOption;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.widget.container.SpruceOptionListWidget;
import dev.lambdaurora.spruceui.widget.container.tabbed.SpruceTabbedWidget;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public abstract class ConfigScreen extends SpruceScreen {
    public final Screen parent;
    public final OptionHolder[] optionHolders;

    public ConfigScreen(Text title, Screen parent, OptionHolder... optionHolders) {
        super(title);
        this.parent = parent;
        this.optionHolders = optionHolders;
    }

    @Override
    protected void init() {
        super.init();

        SpruceTabbedWidget tabs = this.addDrawableChild(new SpruceTabbedWidget(Position.origin(), this.width, this.height, this.getConfigScreenTitle()));
        for (OptionHolder optionHolder : optionHolders) {
            this.addTab(optionHolder, tabs);
        }
    }

    /**
     * The return value of this determines the name of the {@code SpruceTabWidget}.
     * @return The translatable text used to get the title.
     */
    public abstract TranslatableText getConfigScreenTitle();

    private void addTab(OptionHolder optionHolder, SpruceTabbedWidget tabbedWidget) {
        var options = new SpruceOptionListWidget(Position.origin(), this.width, this.height);
        SpruceOption[] optionsArray = new SpruceOption[optionHolder.spruceOptions.size()];
        options.addAll(optionHolder.spruceOptions.toArray(optionsArray));

        tabbedWidget.addTabEntry(optionHolder.getTitle(), optionHolder.getDescription(), options);
    }
}
