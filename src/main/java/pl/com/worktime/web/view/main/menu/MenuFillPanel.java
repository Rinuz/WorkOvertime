package pl.com.worktime.web.view.main.menu;

import com.vaadin.ui.VerticalLayout;
import pl.com.worktime.web.util.Styles;

public class MenuFillPanel extends VerticalLayout {

    public MenuFillPanel() {
        setSizeFull();
        addStyleName(Styles.MENU_BACKGROUND);
    }
}
