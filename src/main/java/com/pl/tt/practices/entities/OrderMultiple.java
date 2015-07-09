package com.pl.tt.practices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
public class OrderMultiple extends Order {

    @Column(nullable = false)
    @OneToMany
    private List<Order> childOrders;

    public OrderMultiple() {
    }

    public OrderMultiple(long version, Table table, List<OrderItem> orderItems, OrderState orderState, List<Order> childOrders) {
        super(version, table, orderItems, orderState);
        this.childOrders = childOrders;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for(Order childOrder : childOrders){
            totalPrice += childOrder.getTotalPrice();
        }
        return totalPrice;
    }

    public void addChildOrder(Order childOrder){
        childOrders.add(childOrder);
    }

    public List<Order> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<Order> childOrders) {
        this.childOrders = childOrders;
    }
}

