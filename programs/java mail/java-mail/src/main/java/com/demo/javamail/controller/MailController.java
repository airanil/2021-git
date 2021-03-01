package com.demo.javamail.controller;

import com.demo.javamail.exception.ServiceException;
import com.demo.javamail.model.UserProfile;
import com.demo.javamail.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/send")
    private String sendMail() throws ServiceException{
        UserProfile userProfile=new UserProfile("Test-Name","test-User","air.anil4655@gmail.com","testing");

        mailService.sendSynchronousForgotPasswordMail(userProfile);
        return "sent";
    }
    
}
