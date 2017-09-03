package pl.com.worktime.application.dto;

import java.time.LocalDate;
import java.util.List;

public class WorkMonthDto {

    private LocalDate month;
    private List<WorkdayDto> workdays;

    public WorkMonthDto(LocalDate month) {
        this.month = month;
    }

    public LocalDate getMonth() {
        return month;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public List<WorkdayDto> getWorkdays() {
        return workdays;
    }

    public void setWorkdays(List<WorkdayDto> workdays) {
        this.workdays = workdays;
    }
}
