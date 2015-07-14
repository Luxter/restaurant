package com.pl.tt.practices.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
public class GroupRequest extends Request {

    @OneToMany
    private Collection<Request> partialRequests;

    public GroupRequest() {
    }

    public GroupRequest(Collection<RequestItem> requestItems, Collection<Request> partialRequests) {
        super(requestItems);
        this.partialRequests = partialRequests;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for(Request childOrder : partialRequests){
            totalPrice += childOrder.getTotalPrice();
        }
        return totalPrice;
    }

    public void addPartialRequest(Request partialRequest){
        partialRequests.add(partialRequest);
    }

    public Collection<Request> getPartialRequests() {
        return partialRequests;
    }

    public void setPartialRequests(Collection<Request> partialRequests) {
        this.partialRequests = partialRequests;
    }
}

