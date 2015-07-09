package com.pl.tt.practices.entities;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
public class OrderSimple extends Order {

    public OrderSimple() {
    }

    public OrderSimple(long version, Table table, List<OrderItem> orderItems, OrderState orderState) {
        super(version, table, orderItems, orderState);
    }
}
