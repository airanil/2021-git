package com.demo.javamail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private String fullName;
    private String username;
    private String emailId;
    private String password;
    
    
}
