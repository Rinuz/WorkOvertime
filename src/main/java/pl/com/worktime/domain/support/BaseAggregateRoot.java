package pl.com.worktime.domain.support;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Radosław Kozdruń
 * 21.08.2017
 */
@Component
@Scope("prototype")
@MappedSuperclass
public abstract class BaseAggregateRoot {

    public static enum AggregateStatus {
        ACTIVE, ARCHIVE
    }

    @EmbeddedId
    protected AggregateId aggregateId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private AggregateStatus aggregateStatus = AggregateStatus.ACTIVE;

    @Version
    private Long version;

    public void markAsRemoved() {
        aggregateStatus = AggregateStatus.ARCHIVE;
    }

    public AggregateId getAggregateId() {
        return aggregateId;
    }

    public boolean isRemoved() {
        return aggregateStatus == AggregateStatus.ARCHIVE;
    }


    public BaseAggregateRoot() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj instanceof BaseAggregateRoot) {
            BaseAggregateRoot other = (BaseAggregateRoot) obj;
            if (other.aggregateId == null)
                return false;
            return other.aggregateId.equals(aggregateId);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return aggregateId.hashCode();
    }
}

