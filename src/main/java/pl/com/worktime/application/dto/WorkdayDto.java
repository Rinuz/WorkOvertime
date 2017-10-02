package pl.com.worktime.application.dto;

import pl.com.worktime.domain.LeaveOfAbsence;
import pl.com.worktime.domain.PresenceType;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

public class WorkdayDto {

    private LocalDate day;
    private String note;
    private PresenceType presenceType;
    private Duration workBreak;
    private LeaveOfAbsence leaveOfAbsence;
    private Set<WorktimeDto> worktimes;
    private Set<OvertimeDto> overtimes;

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PresenceType getPresenceType() {
        return presenceType;
    }

    public void setPresenceType(PresenceType presenceType) {
        this.presenceType = presenceType;
    }

    public Duration getWorkBreak() {
        return workBreak;
    }

    public void setWorkBreak(Duration workBreak) {
        this.workBreak = workBreak;
    }

    public LeaveOfAbsence getLeaveOfAbsence() {
        return leaveOfAbsence;
    }

    public void setLeaveOfAbsence(LeaveOfAbsence leaveOfAbsence) {
        this.leaveOfAbsence = leaveOfAbsence;
    }

    public Set<WorktimeDto> getWorktimes() {
        return worktimes;
    }

    public void setWorktimes(Set<WorktimeDto> worktimes) {
        this.worktimes = worktimes;
    }

    public Set<OvertimeDto> getOvertimes() {
        return overtimes;
    }

    public void setOvertimes(Set<OvertimeDto> overtimes) {
        this.overtimes = overtimes;
    }

    public boolean hasWorktimes() {
        return worktimes != null && worktimes.size() > 0;
    }

    public boolean hasOvertimes() {
        return overtimes != null && overtimes.size() > 0;
    }
}
