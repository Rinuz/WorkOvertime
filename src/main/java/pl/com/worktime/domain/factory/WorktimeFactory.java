package pl.com.worktime.domain.factory;

import pl.com.worktime.domain.User;
import pl.com.worktime.domain.Workday;
import pl.com.worktime.domain.Worktime;
import pl.com.worktime.domain.annotation.DomainFactory;
import pl.com.worktime.domain.exceptions.DomainOperationException;
import pl.com.worktime.domain.repository.WorktimeRepository;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
@DomainFactory
public class WorktimeFactory {

    private static final LocalDateTime DEFAULT_START_OF_WORK = LocalDateTime.now().withHour(8);
    private static final LocalDateTime DEFAULT_END_OF_WORK = LocalDateTime.now().withHour(16);

    @Inject
    private WorktimeRepository worktimeRepository;

    public Worktime createDefaultWorktime(Workday workday, User user) {
        return createWorktime(DEFAULT_START_OF_WORK, DEFAULT_END_OF_WORK, workday, user);
    }

    public Worktime createWorktime(LocalDateTime startOfWork, LocalDateTime endOfWork, Workday workday, User user) {
        if (!canCreate(startOfWork, endOfWork, user)) {
            throw new DomainOperationException("Worktime already exists for user.");
        }
        return new Worktime(startOfWork, endOfWork, workday);
    }

    private boolean canCreate(LocalDateTime startOfWork, LocalDateTime endOfWork, User user) {
        return true;
    }
}
