package com.bridelabz.nitish.cgspringmessangingapp.Controller;

import com.bridelabz.nitish.cgspringmessangingapp.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ControllerContainer {
    private final Person person;

    public ControllerContainer(Person person) {
        this.person = person;
    }
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

    //Make REST Call to show Hello Mark
    //Taylor from BridgeLabz
    //- Use POST Request Method and pass first name and
    //last name in the Body
    //- Create User DTO Bean with firstName and lastName as
    //attributes.
    //- Use CURL to demonstrate the REST API Call
    //- curl -X POST -H "Content-Type: application/json" -d
    //'{"firstName": ”Mark","lastName": ”Taylor"}'
    //"http://localhost:8080/hello/post" -w "\n"

    Map<Long,Person> entry = new HashMap<>();

    @PostMapping("/hello/post")
    public String postName(@RequestBody Person person) {
        entry.put(person.getId(), person);
        return "first name is " + person.getFirstName()  + " and last name is " + person.getLastName();
    }

    @GetMapping("hello/get")
    public List<Person> getData() {
        return new ArrayList<>(entry.values());
    }

    //Make REST Call to show Hello Mark
    //Taylor from BridgeLabz
    //- Use PUT Request Method and pass first name as
    //Path Variable and last name as Query Parameter
    //- Use CURL to demonstrate the REST API Call
    //- curl -X PUT
    //localhost:8080/hello/put/Mark/?lastName=Taylor
    //-w "\n"

    @PutMapping("/hello/put/{firstName}")
    public String putName(@PathVariable String firstName, @RequestParam String lastName) {
        return "Hello " + firstName +"  "+ lastName +" from BridgeLabz ";
    }




}
