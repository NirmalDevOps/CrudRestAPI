package com.myapp.mydemo;

import org.springframework.stereotype.Component;

@Component
public class Customer {

    public Customer(){
        System.out.println("Customer Bean created");
    }
}
