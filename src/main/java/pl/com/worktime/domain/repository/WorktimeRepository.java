package pl.com.worktime.domain.repository;

import pl.com.worktime.domain.Worktime;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
public interface WorktimeRepository {

    Worktime save(Worktime worktime);

    Worktime load(Long id);

    void delete(Worktime id);
}
