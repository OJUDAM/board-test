package com.jpa.factory.common.datasource.queryDslRepositorySupport;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * packageName    : com.jpa.factory.common.datasource
 * fileName       : PrimaryQueryDslRepositorySupport
 * author         : 오주담
 * date           : 2023-01-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-06        오주담       최초 생성
 */
@Repository
public abstract class SecondaryQueryDslRepositorySupport extends QuerydslRepositorySupport {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public SecondaryQueryDslRepositorySupport(Class<?> domainClass) {
        super(domainClass);
    }

    @Override
    @PersistenceContext(unitName = "secondaryEntityManager")
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}
