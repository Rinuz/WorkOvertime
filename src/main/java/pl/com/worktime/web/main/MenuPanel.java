package pl.com.worktime.web.main;

import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import pl.com.worktime.web.main.menu.MenuButton;
import pl.com.worktime.web.main.menu.MenuEmptySpacePanel;
import pl.com.worktime.web.main.menu.MenuTitlePanel;
import pl.com.worktime.web.view.TimesheetView;

/**
 * Radosław Kozdruń
 * 27.08.2017
 */
public class MenuPanel extends Panel {

    public static final int WIDTH = 300;

    private VerticalLayout mainLayout;

    private MenuTitlePanel menuTitlePanel;
    private MenuButton timesheetButton;
    private MenuButton timesheetButton1;
    private MenuEmptySpacePanel emptySpacePanel;

    public MenuPanel() {
        mainLayout = new VerticalLayout();
        mainLayout.setSpacing(false);
        mainLayout.setSizeFull();
        mainLayout.setMargin(false);

        setContent(mainLayout);
        setHeight(100, Unit.PERCENTAGE);
        setWidth(WIDTH, Unit.PIXELS);

        createItems();
    }

    private void createItems() {
        menuTitlePanel = new MenuTitlePanel();
        timesheetButton = new MenuButton("Timesheet", TimesheetView.VIEW_URL);
        timesheetButton1 = new MenuButton("Timesheet1", "");
        emptySpacePanel = new MenuEmptySpacePanel();

        mainLayout.addComponent(menuTitlePanel);
        mainLayout.addComponent(timesheetButton);
        mainLayout.addComponent(timesheetButton1);
        mainLayout.addComponent(emptySpacePanel);

        mainLayout.setExpandRatio(emptySpacePanel, 1f);
    }
}
