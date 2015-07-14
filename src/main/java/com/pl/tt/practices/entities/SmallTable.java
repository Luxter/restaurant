package com.pl.tt.practices.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
public class SmallTable implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private int maxCapacity;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Request> tableRequests;

    public SmallTable() {
    }

    public SmallTable(int maxCapacity, Collection<Request> tableRequests) {
        this.maxCapacity = maxCapacity;
        this.tableRequests = tableRequests;
    }

    public void addTableRequest(Request request){
        tableRequests.add(request);
    }

    public long getId() {
        return id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Collection<Request> getTableRequests() {
        return tableRequests;
    }

    public void setTableRequests(Collection<Request> tableRequests) {
        this.tableRequests = tableRequests;
    }
}
