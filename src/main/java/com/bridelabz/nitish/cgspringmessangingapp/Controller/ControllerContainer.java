package com.bridelabz.nitish.cgspringmessangingapp.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerContainer {
    //uc01Create a Rest Controller to demonstrate
    //the various HTTP Methods and respond
    //hello messages to the User. To begin
    //with show Hello from BridgeLabz
    //- Use GET Request Method
    //- Use CURL to demonstrate the REST API Call

    @GetMapping("hello")
    public String hello() {
        return " Hello from BridgeLabz";
    }

    //Make REST Call to show Hello
    //Mark from BridgeLabz
    //- Use GET Request Method and pass name as
    //query parameter
    //- Use CURL to demonstrate the REST API Call
    //- curl localhost:8080/hello/query?name=Mark
    //-w "\n"

    @GetMapping("/hello/query")
    public String helloWithName(@RequestParam(name = "name",defaultValue = "Guest")String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    //Make REST Call to show Hello
    //Mark from BridgeLabz
    //- Use GET Request Method and pass name as
    //path variable
    //- Use CURL to demonstrate the REST API Call
    //- curl localhost:8080/hello/param/Mark -w
    //"\n"

    @GetMapping("/hello/param/{myName}")
    public String returnName(@PathVariable String myName) {
        return "name present in end of link is : " + myName;
    }


}
