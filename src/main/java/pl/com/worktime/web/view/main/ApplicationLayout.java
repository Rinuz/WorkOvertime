package pl.com.worktime.web.view.main;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Radosław Kozdruń
 * 28.08.2017
 */
public class ApplicationLayout extends HorizontalLayout {

    private VerticalLayout headerAndContentLayout;

    public ApplicationLayout() {
        headerAndContentLayout = new VerticalLayout();
        headerAndContentLayout.setSizeFull();
        headerAndContentLayout.setSpacing(false);
        headerAndContentLayout.setMargin(false);

        setSizeFull();
        setSpacing(false);
        addComponent(headerAndContentLayout);
        setExpandRatio(headerAndContentLayout, 1);
    }

    public void setMenu(MenuPanel menuPanel) {
        this.addComponent(menuPanel, 0);
    }

    public void setHeader(HeaderPanel header) {
        headerAndContentLayout.addComponent(header, 0);
    }

    public void setContent(ContentPanel contentPanel) {
        headerAndContentLayout.addComponent(contentPanel, 1);
        headerAndContentLayout.setExpandRatio(contentPanel, 1);
    }
}
