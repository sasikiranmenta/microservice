package com.sasi.brewery.web.service;

import com.sasi.brewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomer(UUID customerId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void handleUpdate(UUID customerId, CustomerDto customerDto);

    void handleDelete(UUID customerID);
}
