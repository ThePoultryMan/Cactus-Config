package io.github.thepoultryman.cactusconfig.screen;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.option.SpruceOption;
import dev.lambdaurora.spruceui.option.SpruceSeparatorOption;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.widget.container.SpruceOptionListWidget;
import dev.lambdaurora.spruceui.widget.container.tabbed.SpruceTabbedWidget;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

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

        // Find where the separators are located.
        List<Integer> separatorIndexes = new ArrayList<>();
        for (int i = 0; i < optionHolder.spruceOptions.size(); i++) {
            if (optionHolder.spruceOptions.get(i) instanceof SpruceSeparatorOption) separatorIndexes.add(i);
        }

        separatorIndexes.add(optionHolder.spruceOptions.size());

        int currentIndex = 0;
        for (int separatorIndex : separatorIndexes) {
            List<SpruceOption> optionSubList = optionHolder.spruceOptions.subList(currentIndex, separatorIndex);

            // Add options in pairs, and add a single option at the end.
            double pairs = Math.floor(optionSubList.size() / 2f);
            for (int i = 0; i < pairs;) {
                options.addOptionEntry(optionSubList.get(i), optionSubList.get(++i));
            }
            if (pairs * 2 != optionSubList.size()) {
                options.addSingleOptionEntry(optionSubList.get(optionSubList.size() - 1));
            }

            // Mark the current index for next loop.
            currentIndex = separatorIndex + 1;

            // Add separator if this isn't the final index.
            if (separatorIndex != optionHolder.spruceOptions.size())
                options.addSingleOptionEntry(optionHolder.spruceOptions.get(separatorIndex));
        }

        return options;
    }
}
