package com.pl.tt.practices.repositories;

import com.pl.tt.practices.entities.Request;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cyranl on 2015-07-14.
 */
public interface RequestRepository extends CrudRepository<Request, Long> {
}
