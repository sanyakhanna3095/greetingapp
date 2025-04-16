package com.bridgelabz.greetingapp.controller;


import com.bridgelabz.greetingapp.model.UserInfo;
import org.springframework.web.bind.annotation.*;


//to integrate all post methods like get(@GetMapping), put, post, update, delete
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello(){
        return "Hello from Sanya!";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam String name){
        return "Hello "+ name +" !";
    }

    @GetMapping(value = "/param/{name}")
    public String sayHelloParam(@PathVariable String name){
        return "Hello "+ name +" !";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody UserInfo user){
        return "Hello "+ user.getFirstName() + " " + user.getLastName() +" !";
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName){
        return "Hello "+ firstName + " " + lastName +" !";
    }
}
