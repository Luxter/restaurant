package com.pl.tt.practices.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
@Inheritance
public abstract class Request extends Persistable implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    protected Date requestDate;

    @OneToMany()
    protected Collection<RequestItem> requestItems;

    @Enumerated(EnumType.STRING)
    protected RequestState requestState;

    public Request() {
    }

    public Request(Collection<RequestItem> requestItems, RequestState requestState) {
        this.requestItems = requestItems;
        this.requestState = requestState;
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(RequestItem requestItem : requestItems){
            totalPrice += requestItem.getPrice();
        }
        return totalPrice;
    }

    public void addRequestItem(RequestItem requestItem){
        requestItems.add(requestItem);
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Collection<RequestItem> getRequestItems() {
        return requestItems;
    }

    public void setRequestItems(Collection<RequestItem> requestItems) {
        this.requestItems = requestItems;
    }

    public RequestState getRequestState() {
        return requestState;
    }

    public void setRequestState(RequestState requestState) {
        this.requestState = requestState;
    }

    @PrePersist
    public void prePersist(){
        requestDate = new Date();
    }
}
