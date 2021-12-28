package com.springBoot.hibernateDemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Setter
@Getter
@NoArgsConstructor
// @NoArgsConstructor

@Entity
@Table(name = "Flight")
public class Flight implements Serializable{


     /**    
    *
    */
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "FlightId")    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
    @SequenceGenerator(name = "SEQUENCE", sequenceName = "FLIGHT_SEQUENCE", allocationSize = 1, initialValue = 1)	
// CREATE SEQUENCE "HIBERNATE_SEQUENCE" MINVALUE 1 MAXVALUE 100000 INCREMENT BY 1 START WITH 1;     // bydefault hibernate serarches HIBERNATE_SEQUENCE in DB
// CREATE SEQUENCE "FLIGHT_SEQUENCE" MINVALUE 1 MAXVALUE 100000 INCREMENT BY 1 START WITH 1
    public Integer flightId;
    public String flt;
    public String type;
    // public void setId(Integer i){
    //     this.id=i;
    // }
   

    

}
