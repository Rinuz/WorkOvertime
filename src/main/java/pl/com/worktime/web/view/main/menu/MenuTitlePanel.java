package pl.com.worktime.web.view.main.menu;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import pl.com.worktime.web.util.Styles;

import static pl.com.worktime.web.util.SizeUtil.setHeightAndMaxWidth;

public class MenuTitlePanel extends VerticalLayout {

    private static final int HEIGHT = 70;

    private Label titleLabel;

    public MenuTitlePanel() {
        init();
        setProperties();
        setComponents();
    }

    private void init() {
        titleLabel = new Label("Worktime management");
    }

    private void setProperties() {
        setSpacing(false);
        setMargin(false);
        setHeightAndMaxWidth(this, HEIGHT);
        addStyleName(Styles.MENU_TITE);
    }

    private void setComponents() {
        addComponent(titleLabel);
        setComponentAlignment(titleLabel, Alignment.MIDDLE_CENTER);
    }
}
