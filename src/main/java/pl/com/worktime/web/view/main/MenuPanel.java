package pl.com.worktime.web.view.main;

import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import pl.com.worktime.web.WorktimeUI;
import pl.com.worktime.web.view.main.menu.MenuButton;
import pl.com.worktime.web.view.main.menu.MenuFillPanel;
import pl.com.worktime.web.view.main.menu.MenuTitlePanel;
import pl.com.worktime.web.view.SalaryView;
import pl.com.worktime.web.view.TimesheetView;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static pl.com.worktime.web.util.Icons.ICON_SALARY;
import static pl.com.worktime.web.util.Icons.ICON_TIMESHEET;
import static pl.com.worktime.web.util.SizeUtil.setWidthAndMaxHeight;

/**
 * Radosław Kozdruń
 * 27.08.2017
 */
public class MenuPanel extends Panel {

    public static final int WIDTH = 300;

    private VerticalLayout mainLayout;

    private MenuTitlePanel menuTitlePanel;
    private MenuFillPanel emptySpacePanel;
    private List<MenuButton> buttons;

    private MenuButton activeButton;
    private Button.ClickListener clickListener;

    public MenuPanel() {
        init();
        setProperties();
        setComponents();
    }

    private void init() {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setSpacing(false);
        mainLayout.setMargin(false);

        menuTitlePanel = new MenuTitlePanel();

        clickListener = clickEvent -> onButtonClick(clickEvent);
        buttons = newArrayList(
                new MenuButton("Timesheet", TimesheetView.VIEW_URL, ICON_TIMESHEET, clickListener),
                new MenuButton("Salary", SalaryView.VIEW_URL, ICON_SALARY, clickListener)
        );

        emptySpacePanel = new MenuFillPanel();
    }


    private void setProperties() {
        setContent(mainLayout);
        setWidthAndMaxHeight(this, WIDTH);
    }

    private void setComponents() {
        mainLayout.addComponent(menuTitlePanel);
        buttons.forEach(
                menuButton -> {
                    mainLayout.addComponent(menuButton);
                }
        );
        mainLayout.addComponent(emptySpacePanel);
        mainLayout.setExpandRatio(emptySpacePanel, 1f);
    }

    public void onButtonClick(Button.ClickEvent clickEvent) {
        if (activeButton != null) {
            activeButton.setInactiveButtonStyle();
        }

        MenuButton clickedButton = (MenuButton) clickEvent.getButton();
        clickedButton.setActiveButtonStyle();
        activeButton = clickedButton;
        WorktimeUI.openView(clickedButton.getClickUrl());
    }
}
