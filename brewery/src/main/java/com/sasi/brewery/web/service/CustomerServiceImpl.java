package com.sasi.brewery.web.service;

import com.sasi.brewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public CustomerDto getCustomer(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Kiran")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Kiran")
                .build();
    }

    @Override
    public void handleUpdate(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void handleDelete(UUID customerID) {

    }
}
