package pl.com.worktime.infrastructure.repository;

import pl.com.worktime.domain.User;
import pl.com.worktime.domain.annotation.DomainRepositoryImpl;
import pl.com.worktime.domain.repository.UserRepository;

import javax.persistence.EntityManager;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
@DomainRepositoryImpl
public class UserRepositoryImpl extends GenericEntityRepository<User> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
