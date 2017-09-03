package pl.com.worktime.application.dto;

import pl.com.worktime.domain.LeaveType;

public class LeaveOfAbsenceDto {

    private Long id;
    private LeaveType leaveType;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
