package pl.com.worktime.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.com.worktime.domain.annotation.AggregateRoot;
import pl.com.worktime.domain.support.AggregateId;
import pl.com.worktime.domain.support.BaseAggregateRoot;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

/**
 * Radosław Kozdruń
 * 17.08.2017
 */
@AggregateRoot
@Entity
@Table(name = "WORKDAY")
public class Workday extends BaseAggregateRoot {

    @Column(name = "DAY", columnDefinition = "DATE")
    private LocalDate day;

    private String note;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRESENCE_TYPE")
    private PresenceType presenceType;

    @Embedded
    private WorkBreak workBreak;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "leave_id", nullable = false)
    private LeaveOfAbsence leaveOfAbsence;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workday")
    @Fetch(FetchMode.JOIN)
    private Set<Worktime> worktimes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workday")
    @Fetch(FetchMode.JOIN)
    private Set<Overtime> overtimes;

    public Workday() {
    }

    public Workday(AggregateId aggregateId, LocalDate day, User user) {
        this.aggregateId = aggregateId;
        this.presenceType = PresenceType.PRESENT;
        this.day = day;
        this.user = user;
        this.worktimes = newHashSet();
        this.overtimes = newHashSet();
    }

    public void addWorktime(Worktime worktime) {
        worktimes.add(worktime);
    }

    public void removeWorktime(Worktime worktime) {
        worktimes.remove(worktime);
    }

    public void addOvertime(Overtime overtime) {
        overtimes.add(overtime);
    }

    public void addBreak(WorkBreak workBreak) {
        this.workBreak = workBreak;
    }

    public void addLeave(LeaveType leaveType, String description) {
        this.presenceType = PresenceType.LEAVE;
        this.leaveOfAbsence = new LeaveOfAbsence(leaveType, description);
    }

    public void setPresence(PresenceType presenceType) {
        this.presenceType = presenceType;
    }
}
