package com.kafka.kafkaproducer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Flight {
	
	private static final long SerialVersionUID = 10l;
    private String fltId;
    private String fltCarrier;
    private String fltOrg;
    private String fltDst;
    private String msg;
    
}
