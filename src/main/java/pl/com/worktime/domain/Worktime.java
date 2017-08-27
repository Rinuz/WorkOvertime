package pl.com.worktime.domain;

import pl.com.worktime.domain.support.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * Radosław Kozdruń
 * 17.08.2017
 */
@Entity
public class Worktime extends BaseEntity {

    @Embedded
    private WorkPeriod workPeriod;

    @ManyToOne
    @JoinColumn(name = "WORKDAY_ID")
    private Workday workday;

    public Worktime() {
    }

    public Worktime(LocalDateTime startOfWork, LocalDateTime endOfWork, Workday workday) {
        this.workPeriod = new WorkPeriod(startOfWork, endOfWork);
        this.workday = workday;
    }

    public WorkPeriod getWorkPeriod() {
        return workPeriod;
    }
}
