package pl.com.worktime.web.view.timesheet.chart;

import com.vaadin.ui.Label;

import java.time.LocalDateTime;

import static pl.com.worktime.web.util.DateUtil.getHourName;

public class ChartAxisX extends Label {

    public ChartAxisX(LocalDateTime dayTime) {
        setValue(getLabelValue(dayTime));

        addStyleName("workmonth-chart-hour-label");
        setSizeFull();
    }

    private String getLabelValue(LocalDateTime dayTime) {
        String hourName = getHourName(dayTime);
        if ("00:00".equals(hourName)) {
            return "24:00";
        }
        return hourName;
    }
}
