package com.canno.spring.boot.integration.specification;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(value = {GenericEntityListener.class})
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "is_deleted")
    private boolean deleted;

    @Version
    @Column(name = "version")
    private long version;
    @Column(name = "create_time")
    private long createTime;

    @Column(name = "update_time")
    private long updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return id == that.id &&
                deleted == that.deleted &&
                version == that.version &&
                createTime == that.createTime &&
                updateTime == that.updateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deleted, version, createTime, updateTime);
    }
}
