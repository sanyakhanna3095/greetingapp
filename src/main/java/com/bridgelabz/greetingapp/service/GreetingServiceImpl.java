package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements IGreetingService {
    private static final String template= "Hello, %s!";
    private final AtomicLong counter=new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user){
       String message= String.format(template, user.toString().isEmpty()?"Hello World":user.toString());
       return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(long id){
        return greetingRepository.findById(id).get();
    }

    @Override
    public Greeting updateGreeting(long id, User user) {
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found"));
        existingGreeting.setMessage("Hello, " + user.getFirstName() + "!");
        return greetingRepository.save(existingGreeting);
    }

    @Override
    public void deleteGreeting(long id) {
        greetingRepository.deleteById(id);
    }


}
