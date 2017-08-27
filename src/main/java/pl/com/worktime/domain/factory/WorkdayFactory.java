package pl.com.worktime.domain.factory;

import pl.com.worktime.domain.User;
import pl.com.worktime.domain.Workday;
import pl.com.worktime.domain.annotation.DomainFactory;
import pl.com.worktime.domain.support.AggregateId;

import java.time.LocalDate;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
@DomainFactory
public class WorkdayFactory {

    public Workday createWorkday(LocalDate day, User user) {
        Workday workday = new Workday(AggregateId.generate(), day, user);
        return workday;
    }
}
