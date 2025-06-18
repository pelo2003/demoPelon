package com.Pelonzi.demo.service;
import com.Pelonzi.demo.model.Customers;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerItemWriter implements ItemWriter<Customers> {
    @Override
    public void write(List<? extends Customers> customers) {
        customers.forEach(System.out::println);
    }
}
