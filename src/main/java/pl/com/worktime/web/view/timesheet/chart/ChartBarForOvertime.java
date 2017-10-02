package pl.com.worktime.web.view.timesheet.chart;

import com.vaadin.ui.Label;
import pl.com.worktime.application.dto.OvertimeDto;
import pl.com.worktime.application.dto.WorktimeDto;

public class ChartBarForOvertime extends Label {

    public ChartBarForOvertime(OvertimeDto overtime) {
        initPropertes();
    }

    private void initPropertes() {
        setSizeFull();
        addStyleName("workmonth-chart-overtime-bar");
    }
}
