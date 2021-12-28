package com.SpringBootHibernateCrudDemo.SpringBootHibernateCrudDemo.controller;

import com.SpringBootHibernateCrudDemo.SpringBootHibernateCrudDemo.dao.FltRepo;
import com.SpringBootHibernateCrudDemo.SpringBootHibernateCrudDemo.model.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FltController {
  @Autowired
  FltRepo fltRepo;

    @GetMapping("/getFlight")    
    public Iterable<Flight> getFlight() {
       return fltRepo.findAll();
    }

    @GetMapping("/addFlight/{flightId}")
    public Flight addFlight(@PathVariable("flightId") int id) {
        Flight f = new Flight();
        f.setId(id);
        f.setFlt("SQ00" + id);
        f.setType("A");
        return this.fltRepo.save(f);      

    }

}
