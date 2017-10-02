package pl.com.worktime.web.view.timesheet.chart.util;

import pl.com.worktime.application.dto.OvertimeDto;
import pl.com.worktime.application.dto.WorktimeDto;
import pl.com.worktime.web.model.TimesheetModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ChartCoordinatesFactory {

    private static final int AXIS_X_OCCUPIED_ROWS = 2;

    public static ChartCoordinates createBarCoordinates(WorktimeDto worktime) {
        int startHourNumber = worktime.getStartOfWork().getHour();
        int endHourNumber = worktime.getEndOfWork().getHour();
        int dayNumber = worktime.getWorkday().getDay().getDayOfMonth();

        return new ChartCoordinates(startHourNumber, dayNumber - 1, endHourNumber, dayNumber - 1);
    }

    public static ChartCoordinates createBarCoordinates(OvertimeDto overtime) {
        int startHourNumber = overtime.getStartOfWork().getHour();
        int endHourNumber = overtime.getEndOfWork().getHour();
        int dayNumber = overtime.getWorkday().getDay().getDayOfMonth();

        return new ChartCoordinates(startHourNumber, dayNumber - 1, endHourNumber, dayNumber - 1);
    }

    public static ChartCoordinates createAxisXCoordinates(LocalDateTime hour, TimesheetModel model) {
        int hourNumber = hour.getHour();
        int maxRowNumbers = maxRowNumbers(model);

        return new ChartCoordinates(hourNumber, maxRowNumbers - 2, hourNumber, maxRowNumbers - 1);
    }

    public static ChartCoordinates createAxisYCoordinates(LocalDate day) {
        int dayNumber = day.getDayOfMonth();

        return new ChartCoordinates(0, dayNumber - 1, 0, dayNumber - 1);
    }

    public static int maxRowNumbers(TimesheetModel model) {
        return model.getDaysInMonth() + AXIS_X_OCCUPIED_ROWS;
    }
}


