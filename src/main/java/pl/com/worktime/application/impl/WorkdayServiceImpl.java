package pl.com.worktime.application.impl;

import pl.com.worktime.application.WorkdayService;
import pl.com.worktime.application.annotation.ApplicationService;
import pl.com.worktime.domain.Overtime;
import pl.com.worktime.domain.User;
import pl.com.worktime.domain.Workday;
import pl.com.worktime.domain.Worktime;
import pl.com.worktime.domain.factory.WorkdayFactory;
import pl.com.worktime.domain.factory.WorktimeFactory;
import pl.com.worktime.domain.repository.UserRepository;
import pl.com.worktime.domain.repository.WorkdayRepository;
import pl.com.worktime.domain.repository.WorktimeRepository;
import pl.com.worktime.domain.support.AggregateId;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
@ApplicationService
public class WorkdayServiceImpl implements WorkdayService {

    @Inject
    private WorkdayFactory workdayFactory;
    @Inject
    private WorkdayRepository workdayRepository;
    @Inject
    private UserRepository userRepository;
    @Inject
    private WorktimeFactory worktimeFactory;
    @Inject
    private WorktimeRepository worktimeRepository;

    @Override
    public Workday createWorkday() {
        Workday workday = workdayFactory.createWorkday(LocalDate.now(), user());
        return workdayRepository.save(workday);
    }

    @Override
    public Worktime addWorktime(AggregateId workdayId, LocalDateTime startOfWork, LocalDateTime endOfWork) {
        Workday workday = workdayRepository.load(workdayId);
        Worktime worktime = worktimeFactory.createWorktime(startOfWork, endOfWork, workday, user());
        workday.addWorktime(worktime);

        return worktimeRepository.save(worktime);
    }

    @Override
    public void removeWorktime(AggregateId workdayId, Long worktimeId) {
        Workday workday = workdayRepository.load(workdayId);
        Worktime worktime = worktimeRepository.load(worktimeId);
        workday.removeWorktime(worktime);

        worktimeRepository.delete(worktime);
    }

    @Override
    public Overtime addOvertime(AggregateId workdayId, LocalDateTime startOfOvertime, LocalDateTime endOfOvertime) {
        return null;
    }

    @Override
    public void removeOvertime(AggregateId workdayId, Long worktimeId) {
    }

    private User user() {
        return userRepository.load(1L);
    }
}
