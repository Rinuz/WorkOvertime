package pl.com.worktime.domain;

import pl.com.worktime.domain.support.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Radosław Kozdruń
 * 17.08.2017
 */
@Entity
public class LeaveOfAbsence extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private String description;

    public LeaveOfAbsence(LeaveType leaveType, String description) {
        this.leaveType = leaveType;
        this.description = description;
    }
}
