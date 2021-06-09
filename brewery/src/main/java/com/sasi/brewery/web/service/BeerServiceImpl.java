package com.sasi.brewery.web.service;

import com.sasi.brewery.web.model.BrewDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BrewDto getBeerId(UUID beerId) {
        return BrewDto.builder().beerName("sasi")
                                .beerStyle("rocky")
                                .id(UUID.randomUUID())
                                .build();
    }

    @Override
    public BrewDto saveNewBeer(BrewDto brewDto) {
        return BrewDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BrewDto brewDto) {

    }

    @Override
    public void deleteBeer(UUID beerId) {

    }

}
