package pl.com.worktime.domain;

import pl.com.worktime.domain.annotation.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
@Embeddable
@ValueObject
public class WorkPeriod {

    @Column(name = "START_TIME")
    private LocalDateTime startOfWork;

    @Column(name = "END_TIME")
    private LocalDateTime endOfWork;

    public WorkPeriod() {
    }

    public WorkPeriod(LocalDateTime startOfWork, LocalDateTime endOfWork) {
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
    }

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
}
