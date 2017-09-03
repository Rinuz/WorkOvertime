package pl.com.worktime.web;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import pl.com.worktime.web.view.main.ApplicationLayout;
import pl.com.worktime.web.view.main.ContentPanel;
import pl.com.worktime.web.view.main.HeaderPanel;
import pl.com.worktime.web.view.main.MenuPanel;
import pl.com.worktime.web.view.TimesheetView;

@Theme("mytheme")
@SpringUI(path = "worktime")
@SpringViewDisplay
public class WorktimeUI extends UI implements ViewDisplay {

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

        openView(TimesheetView.VIEW_URL);
    }

    @Override
    public void showView(View view) {
        contentPanel.changeView(view);
    }

    public static void openView(String viewName) {
        WorktimeUI.getCurrent().getNavigator().navigateTo(viewName);
    }
}
