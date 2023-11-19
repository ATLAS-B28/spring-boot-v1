package net.example.springstartv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller // a stereotype annotation, makes java class into mvc controller
//@ResponseBody // a web bind annotation, converts java object to json
//instead of using this 2 we use RestController
@RestController //web bind annotation, combining both the functionalities
public class FirstController {

    //HTTP get request
    @GetMapping("/api/v1/hello") // used to map HTTP get request
    // onto the specified handler method
    public String helloWorld(){
        return "Hello World";
    }
}
