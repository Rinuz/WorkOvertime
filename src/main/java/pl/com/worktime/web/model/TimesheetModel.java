package pl.com.worktime.web.model;

import pl.com.worktime.application.dto.WorkdayDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TimesheetModel {

    private List<WorkdayDto> workdays;
    private LocalDate month;

    public List<WorkdayDto> getWorkdays() {

        return workdays;
    }

    public void setWorkdays(List<WorkdayDto> workdays) {
        this.workdays = workdays;
    }

    public LocalDate getMonth() {
        return month;
    }

    public void setMonth(LocalDate month) {
        this.month = month.withDayOfMonth(1);
    }

    public WorkdayDto getWorkday(LocalDate day) {
        return workdays.stream().filter(workday -> workday.getDay().isEqual(day)).findAny().orElseGet(() -> null);
    }

    public int getMonthDays() {
        return getMonth().getMonth().maxLength();
    }

    public LocalDateTime getMonthTime() {
        return month.atTime(0, 0, 0);
    }
}
