package pl.com.worktime.application;

import pl.com.worktime.domain.Overtime;
import pl.com.worktime.domain.Workday;
import pl.com.worktime.domain.Worktime;
import pl.com.worktime.domain.support.AggregateId;

import java.time.LocalDateTime;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
public interface WorkdayService {

    public Workday createWorkday();

    public Worktime addWorktime(AggregateId workdayId, LocalDateTime startOfWork, LocalDateTime endOfWork);

    public void removeWorktime(AggregateId workdayId, Long worktimeId);

    public Overtime addOvertime(AggregateId workdayId, LocalDateTime startOfOvertime, LocalDateTime endOfOvertime);

    public void removeOvertime(AggregateId workdayId, Long worktimeId);
}
