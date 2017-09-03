package pl.com.worktime.web.view.timesheet;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class WorkdayDetailsPanel extends HorizontalLayout {

    public static final int HEIGHT = 800;
    public static final int WIDTH = 400;

    public WorkdayDetailsPanel() {
        addComponent(new Label("workday details"));
        addStyleName("workday-details-panel");
        setHeight(HEIGHT, Unit.PIXELS);
        setWidth(WIDTH, Unit.PIXELS);
    }
}
