package pl.com.worktime.web.view.timesheet.chart;

import com.vaadin.ui.Label;
import pl.com.worktime.application.dto.WorktimeDto;

public class ChartBarForWorktime  extends Label {

    public ChartBarForWorktime(WorktimeDto worktime) {
        initPropertes();
    }

    private void initPropertes() {
        setSizeFull();
        addStyleName("workmonth-chart-worktime-bar");
    }
}
