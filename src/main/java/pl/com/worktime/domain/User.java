package pl.com.worktime.domain;

import pl.com.worktime.domain.support.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
@Entity
@Table(name = "APP_USER")
public class User extends BaseEntity {

    public User() {
    }

    public User(Long id) {
        setId(id);
    }
}
