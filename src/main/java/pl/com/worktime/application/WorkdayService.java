package pl.com.worktime.application;

import pl.com.worktime.application.dto.WorkdayDto;
import pl.com.worktime.domain.Overtime;
import pl.com.worktime.domain.Workday;
import pl.com.worktime.domain.Worktime;
import pl.com.worktime.domain.support.AggregateId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
public interface WorkdayService {

    List<WorkdayDto> getWorkdays(LocalDate month);

    Workday createWorkday();

    Worktime addWorktime(AggregateId workdayId, LocalDateTime startOfWork, LocalDateTime endOfWork);

    void removeWorktime(AggregateId workdayId, Long worktimeId);

    Overtime addOvertime(AggregateId workdayId, LocalDateTime startOfOvertime, LocalDateTime endOfOvertime);

    void removeOvertime(AggregateId workdayId, Long worktimeId);
}
