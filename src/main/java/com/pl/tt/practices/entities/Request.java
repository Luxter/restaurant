package com.pl.tt.practices.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
@Inheritance
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleRequest.class, name = "singleRequest"),
        @JsonSubTypes.Type(value = GroupRequest.class, name = "groupRequest")
})
public abstract class Request extends Persistable implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    protected Date requestDate;

    @OneToMany(cascade = CascadeType.ALL)
    protected Collection<RequestItem> requestItems;

    @Enumerated(EnumType.STRING)
    protected RequestState requestState;

    public Request() {
        requestState = RequestState.PLACED;
    }

    public Request(Collection<RequestItem> requestItems) {
        this.requestItems = requestItems;
        this.requestState = RequestState.PLACED;
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
