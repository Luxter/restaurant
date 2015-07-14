package com.pl.tt.practices.repositories;

import com.pl.tt.practices.entities.RequestState;
import com.pl.tt.practices.entities.SmallTable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cyranl on 2015-07-13.
 */
public interface SmallTableRepository extends CrudRepository<SmallTable, Long>{

    Long countByIdAndTableRequestsRequestState(Long tableId, RequestState requestState);
}
