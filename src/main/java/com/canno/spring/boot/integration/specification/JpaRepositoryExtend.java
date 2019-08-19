package com.canno.spring.boot.integration.specification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @author Gin
 * @since 2019/8/19 16:59
 */
@NoRepositoryBean
public interface JpaRepositoryExtend<T, ID> extends JpaRepository<T,ID>, JpaSpecificationExecutor {
    List<T> findAllWith(Object o);

    Page<T> findAllWith(Object o, Pageable pageable);


}
