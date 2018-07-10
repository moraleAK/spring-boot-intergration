package com.canno.spring.boot.integration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author CannoGcc
 * @since 2018/6/28 14:27
 */
@Entity
@Table(name = "t_order")
public class Order extends BaseEntity {
    @Column(name = "order_no")
    private String orderNo;
    @Column(name = "amount")
    private long amount;
    @Column(name = "status")
    private int status;
    @Column(name = "type")
    private int type;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
