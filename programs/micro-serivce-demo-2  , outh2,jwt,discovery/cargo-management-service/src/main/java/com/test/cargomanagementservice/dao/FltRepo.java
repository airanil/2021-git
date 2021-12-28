package com.test.cargomanagementservice.dao;
import com.test.cargomanagementservice.model.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FltRepo extends CrudRepository<Flight,Integer>{}
    

