package com.bridgelabz.greetingapp.controller;


import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

//@RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/greeting")
//@Configuration
public class GreetingController {
//    private static final String template= "Hello, %s!";
//    private final AtomicLong counter=new AtomicLong();
//
//
//    @GetMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

    @Autowired
    private IGreetingService greetingService;


    @GetMapping("")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        User user=new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable long id){
        return greetingService.getGreetingById(id);
    }

    @PostMapping("/post")
    public Greeting addGreeting(@RequestBody User user) {
        return greetingService.addGreeting(user);
    }

    @PutMapping("/update/{id}")
    public Greeting updateGreeting(@PathVariable long id, @RequestBody User user) {
        return greetingService.updateGreeting(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable long id) {
        greetingService.deleteGreeting(id);
        return "Greeting with ID " + id + " has been deleted.";
    }


}
