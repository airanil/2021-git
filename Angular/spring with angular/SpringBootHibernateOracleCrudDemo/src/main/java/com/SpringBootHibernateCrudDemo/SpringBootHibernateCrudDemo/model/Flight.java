package com.SpringBootHibernateCrudDemo.SpringBootHibernateCrudDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Flight")
public class Flight {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
    @SequenceGenerator(name = "SEQUENCE", sequenceName = "FLIGHT_SEQUENCE", allocationSize = 1, initialValue = 10)
// CREATE SEQUENCE "HIBERNATE_SEQUENCE" MINVALUE 1 MAXVALUE 100000 INCREMENT BY 1 START WITH 1;     // bydefault hibernate serarches HIBERNATE_SEQUENCE in DB
// CREATE SEQUENCE "FLIGHT_SEQUENCE" MINVALUE 1 MAXVALUE 100000 INCREMENT BY 1 START WITH 1
    Integer id;
    String flt;
    String type;
}
