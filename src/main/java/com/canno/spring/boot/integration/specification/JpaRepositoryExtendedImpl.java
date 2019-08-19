package com.canno.spring.boot.integration.specification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Gin
 * @since 2019/8/19 17:03
 */
@Transactional(readOnly = true)
@SuppressWarnings("all")
public class JpaRepositoryExtendedImpl<T,ID> extends SimpleJpaRepository implements JpaRepositoryExtend {
    private final JpaEntityInformation<T, ?> entityInformation;


    public JpaRepositoryExtendedImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityInformation = entityInformation;
    }

    @Override
    public List findAllWith(Object o) {
        return findAll(SpecificationFactory.getConditions(o, getDomainClass()));
    }

    @Override
    public Page findAllWith(Object o, Pageable pageable) {
        return findAll(SpecificationFactory.getConditions(o, getDomainClass()), pageable);
    }
}
