package pl.com.worktime.infrastructure.repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.com.worktime.domain.support.AggregateId;
import pl.com.worktime.domain.support.BaseAggregateRoot;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */
public abstract class GenericAggregateRootRepository<A extends BaseAggregateRoot> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<A> clazz;

    @SuppressWarnings("unchecked")
    public GenericAggregateRootRepository() {
        this.clazz = ((Class<A>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Transactional
    public A load(AggregateId id) {
        A aggregate = entityManager.find(clazz, id, LockModeType.OPTIMISTIC);
        if (aggregate == null) {
            throw new RuntimeException("Aggregate " + clazz.getCanonicalName() + " id = " + id + " does not exist");
        }

        if (aggregate.isRemoved()) {
            throw new RuntimeException("Aggragate + " + id + " is removed.");
        }

        return aggregate;
    }

    public A save(A aggregate) {
        if (entityManager.contains(aggregate)) {
            entityManager.lock(aggregate, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        } else {
            entityManager.persist(aggregate);
        }
        return aggregate;
    }

    public void delete(AggregateId id) {
        A entity = load(id);
        entity.markAsRemoved();
    }
}

