package com.sasi.brewery.web.service;

import com.sasi.brewery.web.model.BrewDto;

import java.util.UUID;

public interface BeerService {

    BrewDto getBeerId(UUID beerId);

    BrewDto saveNewBeer(BrewDto brewDto);

    void updateBeer(UUID beerId, BrewDto brewDto);

    void deleteBeer(UUID beerId);
}
