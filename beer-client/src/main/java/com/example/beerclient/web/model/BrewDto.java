package com.example.beerclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrewDto {

    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;
}