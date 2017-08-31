package pl.com.worktime.web;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import pl.com.worktime.web.main.ApplicationLayout;
import pl.com.worktime.web.main.ContentPanel;
import pl.com.worktime.web.main.HeaderPanel;
import pl.com.worktime.web.main.MenuPanel;

/**
 * Radosław Kozdruń
 * 27.08.2017
 */
@Theme("mytheme")
@SpringUI(path = "worktime")
public class ApplicationUI extends UI implements ViewDisplay {

    private MenuPanel menuPanel;
    private HeaderPanel headerPanel;
    private ContentPanel contentPanel;

    @Override
    protected void init(VaadinRequest request) {
        initLayout();
    }

    private void initLayout() {
        menuPanel = new MenuPanel();
        headerPanel = new HeaderPanel();
        contentPanel = new ContentPanel();

        ApplicationLayout applicationLayout = new ApplicationLayout();
        applicationLayout.setMenu(menuPanel);
        applicationLayout.setHeader(headerPanel);
        applicationLayout.setContent(contentPanel);

        setContent(applicationLayout);
    }

    @Override
    public void showView(View view) {
        contentPanel.changeView(view);
    }

    public static void navigateTo(String viewName) {
        ApplicationUI.getCurrent().getNavigator().navigateTo(viewName);
    }
}
