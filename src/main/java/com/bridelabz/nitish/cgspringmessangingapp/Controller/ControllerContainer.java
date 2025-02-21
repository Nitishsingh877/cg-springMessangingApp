package com.bridelabz.nitish.cgspringmessangingapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ControllerContainer {
    //uc01Create a Rest Controller to demonstrate
    //the various HTTP Methods and respond
    //hello messages to the User. To begin
    //with show Hello from BridgeLabz
    //- Use GET Request Method
    //- Use CURL to demonstrate the REST API Call

    @GetMapping
    public String hello() {
        return " Hello from BridgeLabz";
    }


}
