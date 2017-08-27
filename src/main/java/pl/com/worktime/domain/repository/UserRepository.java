package pl.com.worktime.domain.repository;

import pl.com.worktime.domain.User;

/**
 * Radosław Kozdruń
 * 22.08.2017
 */
public interface UserRepository {

    User load(Long id);
}
