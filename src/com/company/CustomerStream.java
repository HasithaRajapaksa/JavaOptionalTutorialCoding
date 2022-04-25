package com.company;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerStream {

    public static List<Customer> getAll(){
        return Stream.of(
                new Customer(1,"a"),
                new Customer(2,"Mali"),
                new Customer(3,"c")
        ).collect(Collectors.toList());
    }
}
