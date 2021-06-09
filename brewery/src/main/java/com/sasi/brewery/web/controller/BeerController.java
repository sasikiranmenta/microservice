package com.sasi.brewery.web.controller;

import com.sasi.brewery.web.model.BrewDto;
import com.sasi.brewery.web.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController (BeerService beerService){
        this.beerService = beerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{beerId}")
    public ResponseEntity<BrewDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerId(beerId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody BrewDto brewDto){
        BrewDto saveDto = beerService.saveNewBeer(brewDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer"+saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{beerId}")
    //one of the ways to set httpstatus to respone
    public void handleUpdate(@PathVariable UUID beerId, @RequestBody BrewDto brewDto, HttpServletResponse res){
        beerService.updateBeer(beerId,brewDto);
        res.setStatus(HttpStatus.NO_CONTENT.value());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //one of the ways to set httpstatus to response
    public void handleDelete(@PathVariable UUID beerId){
        beerService.deleteBeer(beerId);

    }

}
