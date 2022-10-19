package com.TTN.spring.question1;

//Create a simple REST ful service in Spring Boot which returns the Response "Welcome to spring boot".

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This annotation
// is used at the class level and allows the class to handle the requests made by the client.
//makes restful api
@RestController
public class WelcomeToSpringBoot {


    //@GetMapping annotation maps HTTP GET requests onto specific handler methods.
    @GetMapping(path="/WelcometoSpringBoot")
    public String helloWorld()
    {
        //returns the message to Welcome to spring boot
        return "Welcome to spring boot";

    }
}
