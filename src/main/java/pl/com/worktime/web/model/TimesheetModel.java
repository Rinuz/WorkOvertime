package pl.com.worktime.web.model;

import pl.com.worktime.application.dto.WorkdayDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<WorkdayDto> getWorkday(LocalDate day) {
        return workdays.stream().filter(workday -> workday.getDay().isEqual(day)).findAny();
    }

    public int getDaysInMonth() {
        return getMonth().getMonth().maxLength();
    }

    public LocalDateTime getMonthTime() {
        return month.atTime(0, 0, 0);
    }

    public LocalDate getDayOfMonth(int i) {
        return month.plusDays(i);
    }
}
