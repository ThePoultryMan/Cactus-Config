package io.github.thepoultryman.cactusconfig.screen;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.SpruceTexts;
import dev.lambdaurora.spruceui.option.SpruceOption;
import dev.lambdaurora.spruceui.option.SpruceSeparatorOption;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.widget.SpruceButtonWidget;
import dev.lambdaurora.spruceui.widget.SpruceLabelWidget;
import dev.lambdaurora.spruceui.widget.container.SpruceOptionListWidget;
import dev.lambdaurora.spruceui.widget.container.tabbed.SpruceTabbedWidget;
import io.github.thepoultryman.cactusconfig.CactusConfig;
import io.github.thepoultryman.cactusconfig.CactusTexts;
import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import io.github.thepoultryman.cactusconfig.util.CactusScreenUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ConfigScreen extends SpruceScreen {
    public final Screen parent;
    public final ConfigManager configManager;
    public final OptionHolder[] optionHolders;
    private final ScreenCustomizer screenCustomizer;
    private boolean reset;

    public ConfigScreen(Text title, Screen parent, ConfigManager configManager, OptionHolder... optionHolders) {
        super(title);
        this.parent = parent;
        this.configManager = configManager;
        this.optionHolders = optionHolders;
        this.screenCustomizer = new ScreenCustomizer(title);
    }

    public ConfigScreen(ScreenCustomizer screenCustomizer, Screen parent, ConfigManager configManager, OptionHolder... optionHolders) {
        super(screenCustomizer.getTitle());
        this.parent = parent;
        this.configManager = configManager;
        this.optionHolders = optionHolders;
        this.screenCustomizer = screenCustomizer;
    }

    @Override
    protected void init() {
        super.init();

        // Tabs
        SpruceTabbedWidget tabs = this.addDrawableChild(new SpruceTabbedWidget(Position.origin(), this.width, this.height, null));
        for (OptionHolder optionHolder : optionHolders) {
            tabs.addTabEntry(optionHolder.getTitle(), optionHolder.getDescription(), ((width, height) -> this.buildTab(optionHolder, width, height)));
        }

        // Title Widget
        this.addDrawableChild(new SpruceLabelWidget(Position.of(this, CactusScreenUtil.getTabWidth(tabs), 2), this.screenCustomizer.getTitle(),
                CactusScreenUtil.getTabAccountedWidth(tabs), true));

        // Reset and Done Button
        int xLocation = this.configManager.canReset() ? this.width / 2 + 4 : this.width / 2 - 75;
        this.addDrawableChild(new SpruceButtonWidget(Position.of(this, xLocation, this.height - 28), 150, 20, SpruceTexts.GUI_DONE,
                button -> this.client.setScreen(this.parent)));
        if (this.configManager.canReset()) {
            this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 - 154, this.height - 28), 150, 20, SpruceTexts.RESET_TEXT,
                    button -> {
                if (CactusConfig.CACTUS_CONFIG_MANAGER.skipResetConfirmation) this.resetConfig();
                if (!this.reset) {
                    this.reset = true;
                    button.setMessage(CactusTexts.ARE_YOU_SURE);
                } else {
                    button.setMessage(SpruceTexts.RESET_TEXT);
                    this.resetConfig();
                }
                    }));
        }
    }

    private SpruceOptionListWidget buildTab(OptionHolder optionHolder, int width, int height) {
        var options = new SpruceOptionListWidget(Position.of(0, 15), width, height);

        if (optionHolder.spruceOptions.get(1) instanceof SpruceSeparatorOption) {
            optionHolder.spruceOptions.set(0, optionHolder.spruceOptions.get(1));
            optionHolder.spruceOptions.remove(1);
        }
        // Find where the separators are located.
        List<Integer> separatorIndexes = new ArrayList<>();
        for (int i = 0; i < optionHolder.spruceOptions.size(); i++) {
            if (optionHolder.spruceOptions.get(i) instanceof SpruceSeparatorOption) separatorIndexes.add(i);
        }

        separatorIndexes.add(optionHolder.spruceOptions.size());

        int currentIndex = 0;
        for (int separatorIndex : separatorIndexes) {
            List<SpruceOption> optionSubList = optionHolder.spruceOptions.subList(currentIndex, separatorIndex);

            if (!this.screenCustomizer.shouldUseOneOptionColumn()) {
                // Add options in pairs, and add a single option at the end.
                double pairs = Math.floor(optionSubList.size() / 2f);
                for (int i = 0; i < pairs; ) {
                    options.addOptionEntry(optionSubList.get(i), optionSubList.get(++i));
                }
                if (pairs * 2 != optionSubList.size()) {
                    options.addSingleOptionEntry(optionSubList.get(optionSubList.size() - 1));
                }
            } else {
                // Add options by themselves.
                for (SpruceOption option : optionSubList) {
                    options.addSingleOptionEntry(option);
                }
            }

            // Mark the current index for next loop.
            currentIndex = separatorIndex + 1;

            // Add separator if this isn't the final index.
            if (separatorIndex != optionHolder.spruceOptions.size())
                options.addSingleOptionEntry(optionHolder.spruceOptions.get(separatorIndex));
        }

        return options;
    }

    private void resetConfig() {
        this.reset = false;
        this.configManager.reset();
        this.init(this.client, this.client.getWindow().getScaledWidth(), this.client.getWindow().getScaledHeight());
    }
}
