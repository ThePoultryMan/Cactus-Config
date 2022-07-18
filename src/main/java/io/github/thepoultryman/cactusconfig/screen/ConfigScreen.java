package io.github.thepoultryman.cactusconfig.screen;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.option.SpruceOption;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.widget.container.SpruceOptionListWidget;
import dev.lambdaurora.spruceui.widget.container.tabbed.SpruceTabbedWidget;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ConfigScreen extends SpruceScreen {
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

        SpruceTabbedWidget tabs = this.addDrawableChild(new SpruceTabbedWidget(Position.origin(), this.width, this.height, this.title));
        for (OptionHolder optionHolder : optionHolders) {
            tabs.addTabEntry(optionHolder.getTitle(), optionHolder.getDescription(), ((width, height) -> this.buildTab(optionHolder, width, height)));
        }
    }

    private SpruceOptionListWidget buildTab(OptionHolder optionHolder, int width, int height) {
        var options = new SpruceOptionListWidget(Position.origin(), width, height);

        double amountOfDoubles = Math.floor(optionHolder.spruceOptions.size() / 2f);
        for (int i = 0; i < (amountOfDoubles * 2) - 1;) {
            options.addOptionEntry(optionHolder.spruceOptions.get(i), optionHolder.spruceOptions.get(++i));
        }

        return options;
    }
}
