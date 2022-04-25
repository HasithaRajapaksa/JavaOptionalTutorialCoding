package com.company;

import java.util.Optional;

public class Main {

    /* This code contains Java Optional Type.
    * The Optional type was introduced in Java 8.
    * It provides a clear and explicit way to convey the message that there may not be a value, without using null.
    *  */

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
            System.out.println("read value "+opt.get());
        }

        /*
        orElse()
        if value is null need to return default value
         */

        System.out.println(opt.orElse("default value")); // output - Malik
        System.out.println(nameNull.orElse("default value")); // output - default value

    }
}
