package com.example.dockerdemo.repository;

import com.example.dockerdemo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}