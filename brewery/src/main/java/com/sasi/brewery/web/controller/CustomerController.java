package com.sasi.brewery.web.controller;

import com.sasi.brewery.web.model.CustomerDto;
import com.sasi.brewery.web.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto customerDto1 = customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer/"+customerDto1.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
        customerService.handleUpdate(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void handleDelete(@PathVariable UUID customerID){
        customerService.handleDelete(customerID);
    }


}
