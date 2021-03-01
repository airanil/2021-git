package com.microservice.importservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportController {

    @Value("${message: default  value}")
    public String message;

    @GetMapping("/getConfig")
    public String getConfig(){    
        
        return message;        
    }
    
    @GetMapping("/getImportService")
    public String getImportService(){    
        
        return "import flight service";        
    }
    
}
