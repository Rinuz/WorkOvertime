package pl.com.worktime.domain;

import org.hibernate.annotations.CollectionId;
import pl.com.worktime.domain.annotation.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.Duration;

/**
 * Radosław Kozdruń
 * 17.08.2017
 */
@Embeddable
@ValueObject
public class WorkBreak {

    @Column(name = "BREAK")
    private Duration duration;

    public WorkBreak(int minutes) {
        this.duration = Duration.ofMinutes(minutes);
    }
}
