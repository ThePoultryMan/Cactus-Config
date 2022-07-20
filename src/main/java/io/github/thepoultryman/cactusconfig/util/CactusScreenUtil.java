package io.github.thepoultryman.cactusconfig.util;

import dev.lambdaurora.spruceui.widget.container.tabbed.SpruceTabbedWidget;

public final class CactusScreenUtil {
    public static int getTabAccountedWidth(SpruceTabbedWidget spruceTabbedWidget) {
        return spruceTabbedWidget.getWidth() - spruceTabbedWidget.getList().getWidth();
    }

    public static int getTabWidth(SpruceTabbedWidget spruceTabbedWidget) {
        return spruceTabbedWidget.getList().getWidth();
    }
}
