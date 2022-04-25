package com.company;

import java.util.List;
import java.util.Optional;

public class Main {

    /* This code contains Java Optional Type.
    * The Optional type was introduced in Java 8.
    * It provides a clear and explicit way to convey the message that there may not be a value, without using null.
    * reference - https://www.youtube.com/watch?v=4BUKaazoYyg&t=382s
    *  */

    public static Customer getCustomerByName(String name){
        List<Customer> customerList = CustomerStream.getAll();

        //filter method uses predicate
        return customerList
                .stream()
                .filter(customer -> customer.getName().equals(name))
                .findAny()
                .orElseThrow(()-> new NullPointerException("name is null"));
    }

    public static void main(String[] args) {

        Customer customer1 = new Customer(1,null);
        Customer customer2 = new Customer(2,"Malik");

        /*
        Optional Object creation - 3 ways
        Purpose to use methods
        1 - empty
        2 - of - object that pass to of method need always not null value
        3 - ofNullable - may or may not be null value
         */

        Optional<Object> emptyMethod = Optional.empty();
        System.out.println(emptyMethod);

        //name is null. if of method contains null then returns a null pointer exception
        //Optional<String> nameNull = Optional.of(customer.getName());
        //System.out.println(nameNull);

        //if contains null then returns an empty object and else use previous of method
        Optional<String> nameNull = Optional.ofNullable(customer1.getName());
        System.out.println(nameNull);


        /*
        isPresent() and get()
        get the exact value of the Optional object
        note - not directly get the method - check and get
         */

        Optional<String> opt = Optional.ofNullable(customer2.getName());

        if(opt.isPresent()){
            //can call a other method inside this (api call)
            System.out.println("read value "+opt.get());
        }

        /*
        orElse()
        if value is null need to return default value
         */

        System.out.println(opt.orElse("default value")); // output - Malik
        System.out.println(nameNull.orElse("default value")); // output - default value

         /*
        orElseThrow()
        if value is null need to return custom exception or any
         */

        //System.out.println(nameNull.orElseThrow(()-> new IllegalArgumentException("name is null"))); // output - default value


         /*
        map() and orElseThrow()
         */

        System.out.println(opt
                .map(String::toUpperCase)
                .orElse("default value not upper case"));

          /*
        Optional use with stream API
        */

        getCustomerByName("Malix");

    }
}
