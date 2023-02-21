package com.jpa.factory.common.datasource;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * packageName    : com.jpa.factory.common.datasource
 * fileName       : QueryDslPrimaryConfiguration
 * author         : 오주담
 * date           : 2023-01-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-06        오주담       최초 생성
 */
@Configuration
public class QueryDslConfiguration {

    @PersistenceContext(unitName = "primaryEntityManager")
    EntityManager primaryEntityManager;

    @PersistenceContext(unitName = "secondaryEntityManager")
    EntityManager secondaryEntityManager;

    @Bean(name="primaryQueryFactory")
    public JPAQueryFactory primaryQueryFactory() {
        return new JPAQueryFactory(primaryEntityManager);
    }

    @Bean(name="secondaryQueryFactory")
    public JPAQueryFactory secondaryQueryFactory() {
        return new JPAQueryFactory(secondaryEntityManager);
    }
}
