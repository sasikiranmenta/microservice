package com.example.beerclient;

import com.example.beerclient.web.client.BreweryClient;
import com.example.beerclient.web.model.BrewDto;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeerClientApplication {

    public static void main(String[] args) {
         Logger Log = LoggerFactory.getLogger(BeerClientApplication.class);
        ConfigurableApplicationContext applicationContext=SpringApplication.run(BeerClientApplication.class, args);
        Log.info(applicationContext.getBean(BreweryClient.class).apiHost);
    }

}
