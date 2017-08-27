package pl.com.worktime.infrastructure.repository;

import com.google.common.base.Preconditions;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.util.Assert;
import pl.com.worktime.domain.support.BaseEntity;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

/**
 * Radosław Kozdruń
 * 20.08.2017
 */

public abstract class GenericEntityRepository<T extends BaseEntity> {

    protected EntityManager entityManager;
    protected Class<T> domainClass;

    private JpaEntityInformation<T, ?> entityInformation;

    public GenericEntityRepository(EntityManager entityManager) {
        this.domainClass = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    public T save(T entity) {
        if (entityInformation.isNew(entity)) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    public T load(Long id) {
        Preconditions.checkNotNull(id, "The given id must not be null!");
        return entityManager.find(domainClass, id);
    }

    public void delete(T entity) {
        Assert.notNull(entity, "The entity must not be null!");
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}

