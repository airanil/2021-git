package com.demo.springBootCrud.model;

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
//@Setter
//@Getter
//@NoArgsConstructor
// @NoArgsConstructor

@Entity
@Table(name = "Flight")
public class Flight implements Serializable{


     /**    
    *
    */
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")    
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
   // @SequenceGenerator(name = "SEQUENCE", sequenceName = "FLIGHT_SEQUENCE", allocationSize = 1, initialValue = 10)
    public int id;
    public String flt;
    public String type;
    // public void setId(Integer i){
    //     this.id=i;
    // }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlt() {
        return flt;
    }

    public void setFlt(String flt) {
        this.flt = flt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

}
