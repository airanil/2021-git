package com.test.cargoexportservice.controller;

import com.test.cargoexportservice.dao.FltRepo;
import com.test.cargoexportservice.model.Flight;

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
        f.setFlightId(id);
        f.setFlt("SQ00" + id);
        f.setType("A");
        return this.fltRepo.save(f);      

    }

}
