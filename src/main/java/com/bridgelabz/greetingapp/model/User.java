package com.bridgelabz.greetingapp.model;


import jakarta.persistence.Entity;

public class User {
    private String firstName;

    public String getFirstName(){
        return firstName;
    }


    public void setFirstName(String firstName){
        this.firstName=firstName;
    }


    @Override
    public String toString() {
        return firstName;
    }
}
