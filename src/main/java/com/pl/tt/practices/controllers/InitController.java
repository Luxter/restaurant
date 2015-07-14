package com.pl.tt.practices.controllers;

import com.pl.tt.practices.entities.SmallTable;
import com.pl.tt.practices.repositories.SmallTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by cyranl on 2015-07-13.
 */
@RestController
public class InitController {

    @Autowired
    private SmallTableRepository smallTableRepository;

    @RequestMapping("/init")
    public void index(){
        SmallTable table1 = new SmallTable(1, new ArrayList<>());
        SmallTable table2 = new SmallTable(20, new ArrayList<>());
        SmallTable table3 = new SmallTable(3, new ArrayList<>());
        smallTableRepository.save(table1);
        smallTableRepository.save(table2);
        smallTableRepository.save(table3);
    }
}
