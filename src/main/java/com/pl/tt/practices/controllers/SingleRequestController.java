package com.pl.tt.practices.controllers;

import com.pl.tt.practices.entities.RequestItem;
import com.pl.tt.practices.entities.RequestState;
import com.pl.tt.practices.entities.SingleRequest;
import com.pl.tt.practices.repositories.SingleRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by cyranl on 2015-07-13.
 */
@RestController
public class SingleRequestController {

    @Autowired
    SingleRequestRepository repository;

    @RequestMapping("/")
    public String index(){
        RequestItem item1 = new RequestItem("nazwa1", 10);
        RequestItem item2 = new RequestItem("nazwa2", 20);
        Collection<RequestItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        repository.save(new SingleRequest(items, RequestState.PLACED));
        return "test";
    }
}
