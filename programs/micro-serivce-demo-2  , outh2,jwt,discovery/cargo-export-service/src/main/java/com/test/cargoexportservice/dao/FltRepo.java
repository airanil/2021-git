package com.test.cargoexportservice.dao;
import com.test.cargoexportservice.model.Flight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FltRepo extends CrudRepository<Flight,Integer>{}
    

