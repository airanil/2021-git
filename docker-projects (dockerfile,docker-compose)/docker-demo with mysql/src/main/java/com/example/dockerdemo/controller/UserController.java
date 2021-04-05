package com.example.dockerdemo.controller;

import com.example.dockerdemo.model.User;
import com.example.dockerdemo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired 
  private UserRepository userRepository;

  @GetMapping("/test")
  public String test(){
      return "testing file";
  }

  @PostMapping(path="/add") 
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/getAll")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
    
}
