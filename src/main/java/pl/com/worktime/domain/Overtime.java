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
public class Overtime extends BaseEntity {

    @Embedded
    private WorkPeriod workPeriod;

    @ManyToOne
    @JoinColumn(name = "WORKDAY_ID")
    private Workday workday;

    public Overtime(LocalDateTime startOfWork, LocalDateTime endOfWork) {
        this.workPeriod = new WorkPeriod(startOfWork, endOfWork);
    }
}
