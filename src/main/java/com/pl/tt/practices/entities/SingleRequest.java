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
}
