package com.canno.blog.entity;

import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Canno
 * @since 2018/6/28 14:26
 */
@Component
public class GenericEntityListener {
    @PrePersist
    public void prePersist(BaseEntity entity) {
        entity.setCreateTime(System.currentTimeMillis());
        entity.setUpdateTime(entity.getCreateTime());
    }

    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        entity.setUpdateTime(System.currentTimeMillis());
    }
}
