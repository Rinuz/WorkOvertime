package pl.com.worktime.web.view;

import com.vaadin.spring.annotation.SpringView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.com.worktime.web.model.TimesheetModel;
import pl.com.worktime.web.presenter.TimesheetPresenter;
import pl.com.worktime.web.util.Styles;
import pl.com.worktime.web.util.component.ViewHorizontal;
import pl.com.worktime.web.view.timesheet.WorkMonthPanel;
import pl.com.worktime.web.view.timesheet.WorkdayDetailsPanel;


@SpringView(name = TimesheetView.VIEW_URL)
public class TimesheetView extends ViewHorizontal<TimesheetPresenter> {

    private static final Logger LOG = LoggerFactory.getLogger(TimesheetView.class);

    public static final String VIEW_URL = "timesheet";

    private WorkMonthPanel workMonthPanel;
    private WorkdayDetailsPanel workdayDetailsPanel;

    @Autowired
    public TimesheetView(TimesheetPresenter presenter) {
        super(presenter);
    }

    @Override
    public void initLayout() {
        workMonthPanel = new WorkMonthPanel();
        workdayDetailsPanel = new WorkdayDetailsPanel();

        addComponent(workMonthPanel);
        addComponent(workdayDetailsPanel);
        setExpandRatio(workMonthPanel, 1f);
    }

    @Override
    public void initProperties() {
        setSizeFull();
        setMargin(true);
        setSpacing(true);
        addStyleName(Styles.VIEW_PANEL);
    }

    public void loadWorkMonthChart(TimesheetModel model) {
        workMonthPanel.loadChart(model);
    }

    public void loadWorkMonthSummery(TimesheetModel model) {
    }
}
