package com.pl.tt.practices.repositories;

import com.pl.tt.practices.entities.SingleRequest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cyranl on 2015-07-13.
 */
public interface SingleRequestRepository extends CrudRepository<SingleRequest, Long> {
}
