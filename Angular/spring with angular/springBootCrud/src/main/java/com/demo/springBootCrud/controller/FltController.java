package com.demo.springBootCrud.controller;

import java.util.List;

import com.demo.springBootCrud.model.Flight;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FltController {

    Configuration cfg = new Configuration().configure();

    @GetMapping("/getFlight")
    public List<Flight> getFlight() {

        cfg.addAnnotatedClass(Flight.class);
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        List<Flight> list = session.createQuery("from Flight").list();
        session.close();
        return list;
        // return null;

    }

    @GetMapping("/addFlight/{flightId}")
    public int addFlight(@PathVariable("flightId") int id) {
        Flight f = new Flight();
        f.setId(id);
        f.setFlt("SQ00" + id);
        f.setType("A");

        cfg.addAnnotatedClass(Flight.class);
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        int i = (int) session.save(f);
        session.getTransaction().commit();
        session.close();
        factory.close();

        return i;

    }

}
