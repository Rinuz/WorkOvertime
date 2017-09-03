package pl.com.worktime.web.view.timesheet;

import com.vaadin.ui.Label;

import java.time.LocalDate;

import static pl.com.worktime.web.util.DateUtil.getDayNumber;

public class ChartDayLabel extends Label {

    public ChartDayLabel(LocalDate day) {
        setValue(getDayNumber(day));

        addStyleName("workmonth-chart-day-label");
        setSizeFull();
    }
}
