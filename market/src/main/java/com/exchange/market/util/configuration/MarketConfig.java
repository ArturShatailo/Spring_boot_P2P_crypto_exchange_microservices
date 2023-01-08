package com.exchange.market.util.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MarketConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public String clientAddress(){
        return "http://localhost:8090/api/client/c";
    }

    @Bean
    public String isVerifiedClient(){
        String createController = "/v?email={email}";
        return clientAddress() + createController;
    }

}
