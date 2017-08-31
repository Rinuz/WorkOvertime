package pl.com.worktime.web.main.menu;

import com.vaadin.ui.Button;
import pl.com.worktime.web.resource.ResourceManager;

/**
 * Radosław Kozdruń
 * 30.08.2017
 */
public class MenuButton extends Button {

    private static final int HEIGHT = 100;

    private String viewName;
    private String viewUrl;

    public MenuButton(String viewName, String viewUrl) {
        this.viewName = viewName;
        this.viewUrl = viewUrl;

        init();
    }

    private void init() {
        setWidth(100, Unit.PERCENTAGE);
        setHeight(HEIGHT, Unit.PIXELS);
        setCaption(viewName);
        addStyleName("menu-button");
        addStyleName("menu-button-inactive");
        setIcon(ResourceManager.getIcon("timesheet"));

        this.addFocusListener(clickEvent -> {
            removeStyleName("menu-button-inactive");
            addStyleName("menu-button-active");
        });

        this.addBlurListener(clickEvent -> {
            addStyleName("menu-button-inactive");
            removeStyleName("menu-button-active");
        });
    }
}

/*


*/

