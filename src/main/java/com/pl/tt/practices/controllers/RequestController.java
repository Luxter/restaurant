package com.pl.tt.practices.controllers;

import com.pl.tt.practices.entities.Request;
import com.pl.tt.practices.entities.RequestState;
import com.pl.tt.practices.repositories.ReceiptService;
import com.pl.tt.practices.repositories.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

/**
 * Created by cyranl on 2015-07-14.
 */
@RestController
public class RequestController {
    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    ReceiptService receiptService;

    @Autowired
    RequestRepository requestRepository;

    @RequestMapping(value = "/payrequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void payRequest(@RequestBody Request request){
        try {
            Request requestToUpdate = requestRepository.findOne(request.getId());
            receiptService.printReceipt(requestToUpdate);
            requestToUpdate.setRequestState(RequestState.FINISHED);
            requestRepository.save(requestToUpdate);
        }catch (FileNotFoundException ex){
            logger.error(ex.getMessage());
        }
    }
}
