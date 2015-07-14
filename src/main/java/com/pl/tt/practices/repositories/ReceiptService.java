package com.pl.tt.practices.repositories;

import com.pl.tt.practices.entities.Request;
import com.pl.tt.practices.entities.RequestItem;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by cyranl on 2015-07-14.
 */
@Service
public class ReceiptService {
    public void printReceipt(Request request) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("Receipt.txt"));
        writer.println("'RESTaurant'");
        writer.println("Receipt");
        writer.println(request.toString());
        writer.close();
    }
}
