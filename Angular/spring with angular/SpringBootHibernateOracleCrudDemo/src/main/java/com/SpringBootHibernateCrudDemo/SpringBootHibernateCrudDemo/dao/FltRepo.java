package com.SpringBootHibernateCrudDemo.SpringBootHibernateCrudDemo.dao;

import com.SpringBootHibernateCrudDemo.SpringBootHibernateCrudDemo.model.Flight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FltRepo extends CrudRepository<Flight,Integer>{}
    

