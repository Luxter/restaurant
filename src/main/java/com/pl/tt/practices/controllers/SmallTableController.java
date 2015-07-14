package com.pl.tt.practices.controllers;

import com.pl.tt.practices.entities.Request;
import com.pl.tt.practices.entities.RequestState;
import com.pl.tt.practices.entities.SmallTable;
import com.pl.tt.practices.repositories.SmallTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cyranl on 2015-07-13.
 */
@RestController
public class SmallTableController {

    @Autowired
    SmallTableRepository smallTableRepository;

    @RequestMapping(value = "/gettable", method = RequestMethod.GET)
    public SmallTable getSmallTable(@RequestParam(value="id") Long id){
        return smallTableRepository.findOne(id);
    }

    @RequestMapping(value = "/addrequest", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addRequest(@RequestBody SmallTable table){
        SmallTable tableToUpdate = smallTableRepository.findOne(table.getId());
        if(smallTableRepository.countByIdAndTableRequestsRequestState(table.getId(), RequestState.PLACED) < tableToUpdate.getMaxCapacity()) {
            tableToUpdate.setTableRequests(table.getTableRequests());
            smallTableRepository.save(tableToUpdate);
        }
        else{
            System.out.println("Brak wolnych miejsc!!!");
        }
    }
}
