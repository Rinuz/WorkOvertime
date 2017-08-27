package pl.com.worktime.infrastructure.repository;

import pl.com.worktime.domain.Worktime;
import pl.com.worktime.domain.annotation.DomainRepositoryImpl;
import pl.com.worktime.domain.repository.WorktimeRepository;

import javax.persistence.EntityManager;

/**
 * Radosław Kozdruń
 * 23.08.2017
 */
@DomainRepositoryImpl
public class WorktimeRepositoryImpl extends GenericEntityRepository<Worktime> implements WorktimeRepository {

    public WorktimeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
