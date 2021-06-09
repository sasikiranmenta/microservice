package com.sasi.beerservice.web.controller;

import com.sasi.beerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping(value = "/ap1/v1/beerUpc")
@RestController
public class BeerServiceControllerUpc {

    @RequestMapping(method = RequestMethod.GET, value = "/{upc}")
    public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable("upc") long upc){
        return new ResponseEntity<>(BeerDto.builder().id(UUID.randomUUID()).build(), HttpStatus.OK);
    }
}
