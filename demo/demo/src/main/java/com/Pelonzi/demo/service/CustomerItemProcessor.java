package com.Pelonzi.demo.service;

import com.Pelonzi.demo.model.Customers;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerItemProcessor implements ItemProcessor<Customers, Customers> {

    @Override
    public Customers process(Customers customer) {
        customer.setTitle(customer.getTitle().toUpperCase()); // Modify title for demonstration
        return customer;
    }
}