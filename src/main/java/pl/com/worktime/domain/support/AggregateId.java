package pl.com.worktime.domain.support;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

/**
 * Radosław Kozdruń
 * 21.08.2017
 */
@SuppressWarnings("serial")
@Embeddable
public class AggregateId implements Serializable {

    @Column(name = "ID", nullable = false)
    private String aggregateId;

    public AggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    protected AggregateId() {
    }

    public static AggregateId generate() {
        return new AggregateId(UUID.randomUUID().toString());
    }

    public String getId() {
        return aggregateId;
    }

    @Override
    public int hashCode() {
        return aggregateId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AggregateId other = (AggregateId) obj;
        if (aggregateId == null) {
            if (other.aggregateId != null)
                return false;
        } else if (!aggregateId.equals(other.aggregateId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return aggregateId;
    }
}

