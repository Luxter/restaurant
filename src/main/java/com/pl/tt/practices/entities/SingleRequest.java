package com.pl.tt.practices.entities;

import javax.persistence.Entity;
import java.util.Collection;

/**
 * Created by cyranl on 2015-07-09.
 */
@Entity
public class SingleRequest extends Request {

    public SingleRequest() {
    }

    public SingleRequest(Collection<RequestItem> requestItems) {
        super(requestItems);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Date:" + requestDate).append("\n");
        for(RequestItem item : requestItems){
            sb.append("\t").append(item.toString()).append("\n");
        }
        sb.append("\t").append("Total: " + getTotalPrice()).append("\n");
        return sb.toString();
    }
}
