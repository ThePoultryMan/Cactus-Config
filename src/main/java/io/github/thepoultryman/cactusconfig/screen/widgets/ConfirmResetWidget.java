package io.github.thepoultryman.cactusconfig.screen.widgets;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.background.EmptyBackground;
import dev.lambdaurora.spruceui.widget.SpruceButtonWidget;
import dev.lambdaurora.spruceui.widget.container.SpruceContainerWidget;
import io.github.thepoultryman.cactusconfig.screen.ConfigScreen;
import net.minecraft.client.gui.screen.ScreenTexts;

public class ConfirmResetWidget extends SpruceContainerWidget {
    public ConfirmResetWidget(ConfigScreen parent, Position position, int width, int height) {
        super(position, width, height);
        this.setBackground(EmptyBackground.EMPTY_BACKGROUND);
        this.setVisible(false);

        SpruceButtonWidget resetButton = new SpruceButtonWidget(Position.of(this, 0, 0), this.getWidth() / 2, 20,
                ScreenTexts.PROCEED, button -> {
            parent.configManager.reset();
            parent.init(parent.getClient(), parent.getClient().getWindow().getScaledWidth(), parent.getClient().getWindow().getScaledHeight());
        });
        SpruceButtonWidget cancelButton = new SpruceButtonWidget(Position.of(this, 10, 0), this.getWidth() / 2, 20,
                ScreenTexts.CANCEL, button -> this.setVisible(false));

        this.addChild(resetButton);
        this.addChild(cancelButton);
    }
}
