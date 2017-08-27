package pl.com.worktime.domain.repository;

import pl.com.worktime.domain.Workday;
import pl.com.worktime.domain.support.AggregateId;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
public interface WorkdayRepository {

    Workday save(Workday workday);

    Workday load(AggregateId workdayId);
}
