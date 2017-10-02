package pl.com.worktime.web.view.timesheet.chart;

import com.vaadin.ui.Label;

import java.time.LocalDate;

import static pl.com.worktime.web.util.DateUtil.getDayNumber;

public class ChartAxisY extends Label {

    public ChartAxisY(LocalDate day) {
        setValue(getDayNumber(day));

        addStyleName("workmonth-chart-day-label");
        setSizeFull();
    }
}
