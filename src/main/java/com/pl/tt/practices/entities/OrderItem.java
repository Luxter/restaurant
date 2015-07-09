package com.pl.tt.practices.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    @ManyToOne()
    @JoinColumn(name = "id")
    private Order order;

    public OrderItem() {
    }

    public OrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
