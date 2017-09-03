package pl.com.worktime.web.view.main.menu;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import pl.com.worktime.web.util.Styles;

import static pl.com.worktime.web.util.SizeUtil.setHeightAndMaxWidth;

public class MenuButton extends Button {

    private static final int HEIGHT = 80;

    private String buttonName;
    private String clickUrl;

    public MenuButton(String buttonName, String clickUrl, ThemeResource icon, ClickListener clickListener) {
        this.buttonName = buttonName;
        this.clickUrl = clickUrl;

        setProperties(icon);
        addClickListener(clickListener);
    }

    private void setProperties(ThemeResource icon) {
        setCaption(buttonName);
        setIcon(icon);
        setHeightAndMaxWidth(this, HEIGHT);
        addStyleNames(Styles.MENU_BUTTON_BASE, Styles.MENU_BUTTON_INACTIVE);
    }

    public void setActiveButtonStyle() {
        removeStyleName(Styles.MENU_BUTTON_INACTIVE);
        addStyleName(Styles.MENU_BUTTON_ACTIVE);
    }

    public void setInactiveButtonStyle() {
        addStyleName(Styles.MENU_BUTTON_INACTIVE);
        removeStyleName(Styles.MENU_BUTTON_ACTIVE);
    }

    public String getClickUrl() {
        return clickUrl;
    }
}

