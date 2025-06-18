package com.Pelonzi.demo.service;

import com.Pelonzi.demo.model.Customers;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomerItemReader {

    public IteratorItemReader<Customers> reader() {
        RestTemplate restTemplate = new RestTemplate();
        Customers[] customers = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", Customers[].class);
        List<Customers> customerList = Arrays.asList(customers);
        return new IteratorItemReader<>(customerList);
    }
}