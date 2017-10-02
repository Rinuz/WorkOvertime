package pl.com.worktime.web.view.timesheet.chart;

import com.vaadin.ui.HorizontalLayout;
import pl.com.worktime.application.dto.WorkdayDto;
import pl.com.worktime.domain.Worktime;

public class ChartBar extends HorizontalLayout {

    public ChartBar(WorkdayDto workday) {

    }

    public int startCoordinate() {
        return 1;
    }

    public int endCoordinate() {
        return 3;
    }
}
