package pl.com.worktime.application.dto;

import java.time.LocalDateTime;

public class OvertimeDto {

    private LocalDateTime startOfWork;
    private LocalDateTime endOfWork;
    private WorkdayDto workday;

    public LocalDateTime getStartOfWork() {
        return startOfWork;
    }

    public void setStartOfWork(LocalDateTime startOfWork) {
        this.startOfWork = startOfWork;
    }

    public LocalDateTime getEndOfWork() {
        return endOfWork;
    }

    public void setEndOfWork(LocalDateTime endOfWork) {
        this.endOfWork = endOfWork;
    }

    public WorkdayDto getWorkday() {
        return workday;
    }

    public void setWorkday(WorkdayDto workday) {
        this.workday = workday;
    }
}
