package com.pl.tt.practices;

import com.pl.tt.practices.entities.RequestItem;
import com.pl.tt.practices.entities.SingleRequest;
import com.pl.tt.practices.repositories.SingleRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantApplication {

    @Autowired
    static SingleRequestRepository repository;

    public static void main(String[] args) {
        RequestItem item1 = new RequestItem("nazwa1", 10);
        RequestItem item2 = new RequestItem("nazwa2", 20);

        repository.save(new SingleRequest());
        SpringApplication.run(RestaurantApplication.class, args);
    }
}
