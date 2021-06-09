package com.sasi.beerservice.web.controller;

import com.sasi.beerservice.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerServiceController {

    @RequestMapping(method= RequestMethod.GET,value = "/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
        //todo
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity saveBeer(@RequestBody BeerDto beerDto){
        //todo
        BeerDto beerDto1 = BeerDto.builder().id(UUID.randomUUID()).build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer"+beerDto1.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.PUT,value="/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@RequestBody BeerDto beerDto, @PathVariable("beerId") UUID beerId){
        //todo

    }
    @RequestMapping(method = RequestMethod.DELETE,value="/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        //todo
    }

}
