package com.pl.tt.practices.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by cyranl on 2015-07-09.
 */
@MappedSuperclass
public abstract class Order implements Serializable {

    @Id
    @GeneratedValue
    protected long id;

    @Version
    @Column(nullable = false)
    protected long version;

    @Column(nullable = false)
    protected Timestamp date;

    @Column(nullable = false)
    protected Table table;

    @Column(nullable = false)
    @OneToMany(mappedBy = "order")
    protected List<OrderItem> orderItems;

    @Column(nullable = false)
    protected OrderState orderState;

    public Order() {
    }

    public Order(long version, Table table, List<OrderItem> orderItems, OrderState orderState) {
        this.version = version;
        this.table = table;
        this.orderItems = orderItems;
        this.orderState = orderState;
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(OrderItem orderItem : orderItems){
            totalPrice += orderItem.getPrice();
        }
        return totalPrice;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public Timestamp getDate() {
        return date;
    }

    public Table getTable() {
        return table;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
