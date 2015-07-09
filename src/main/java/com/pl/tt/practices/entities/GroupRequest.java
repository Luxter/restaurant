package com.pl.tt.practices.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
public class GroupRequest extends Request {

    @OneToMany
    private List<Request> partialRequests;

    public GroupRequest() {
    }

    public GroupRequest(List<RequestItem> requestItems, RequestState requestState, List<Request> partialRequests) {
        super(requestItems, requestState);
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

    public List<Request> getPartialRequests() {
        return partialRequests;
    }

    public void setPartialRequests(List<Request> partialRequests) {
        this.partialRequests = partialRequests;
    }
}

