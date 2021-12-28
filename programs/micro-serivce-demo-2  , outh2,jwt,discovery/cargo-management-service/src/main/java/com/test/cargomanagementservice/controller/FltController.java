package com.test.cargomanagementservice.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.test.cargomanagementservice.dao.*;
import com.test.cargomanagementservice.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.ApiOperation;

@RestController
public class FltController {
  //private static final Class Flight = null;
  @Autowired
  FltRepo fltRepo;

  @Autowired
  RestTemplate restTemplate;

  @ApiOperation(value = "GET FLIGHT")
  @GetMapping("/getFlight")
  public ResponseEntity<Flight[]> getFlight(@RequestHeader ("Authorization") String authorizationToken) {
    // final String uri = "http://localhost:8080/springrestexample/employees/{id}";
    final String url = "http://cargo-export-service/getFlight";

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    String tocken=authorizationToken;
    headers.add("Authorization",tocken );
    HttpEntity<String> entity = new HttpEntity<>("body", headers);

      return restTemplate.exchange(url, HttpMethod.GET, entity, Flight[].class);
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/user")
  public String user() {   
      return "user";
  }
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/admin")
  public String admin() {   
      return "admin";
  }

  @GetMapping("/addFlight/{flightId}")
  public Flight addFlight(@PathVariable("flightId") int id) {
    Flight f = new Flight();
    f.setFlightId(id);
    f.setFlt("SQ00" + id);
    f.setType("A");

    final String uri = "http://localhost:8083/addFlight/{flightId}";
    RestTemplate restTemplate = new RestTemplate();

    Map<String, Integer> params = new HashMap<String, Integer>();
    params.put("flightId", id);

    return restTemplate.getForObject(uri, Flight.class,params);

  }

}
