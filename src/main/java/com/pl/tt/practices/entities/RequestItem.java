package com.pl.tt.practices.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
public class RequestItem implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private double price;

    public RequestItem() {
    }

    public RequestItem(String name, double price) {
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

    @Override
    public String toString() {
        return name + " " + price;
    }
}
