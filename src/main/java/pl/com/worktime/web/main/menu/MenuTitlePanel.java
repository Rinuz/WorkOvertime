package pl.com.worktime.web.main.menu;

import com.vaadin.ui.Label;

/**
 * Radosław Kozdruń
 * 30.08.2017
 */
public class MenuTitlePanel extends Label {

    private static final int HEIGHT = 70;

    public MenuTitlePanel() {
        setHeight(HEIGHT, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);
        setValue("Worktime");
        addStyleName("menu-background");
        addStyleName("menu-tite");
    }


}
