package pl.com.worktime.infrastructure.repository;

import pl.com.worktime.domain.Workday;
import pl.com.worktime.domain.repository.WorkdayRepository;
import pl.com.worktime.domain.annotation.DomainRepositoryImpl;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
@DomainRepositoryImpl
public class WorkdayRepositoryImpl extends GenericAggregateRootRepository<Workday> implements WorkdayRepository {

}
