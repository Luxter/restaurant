package com.pl.tt.practices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
public class Table {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int maxCapacity;

    public Table() {
    }

    public Table(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public long getId() {
        return id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
