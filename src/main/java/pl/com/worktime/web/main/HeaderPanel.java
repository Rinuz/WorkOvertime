package pl.com.worktime.web.main;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * Radosław Kozdruń
 * 28.08.2017
 */
public class HeaderPanel extends Panel {

    public static final int HEIGHT = 70;

    private HorizontalLayout mainLayout;

    public HeaderPanel() {
        mainLayout = new HorizontalLayout();
        mainLayout.setSizeFull();
        mainLayout.addComponent(new Label("nagłówek"));

        this.setContent(mainLayout);
        this.setHeight(HEIGHT, Unit.PIXELS);
        this.setWidth(100, Unit.PERCENTAGE);
        addStyleName("header-background");
    }
}
