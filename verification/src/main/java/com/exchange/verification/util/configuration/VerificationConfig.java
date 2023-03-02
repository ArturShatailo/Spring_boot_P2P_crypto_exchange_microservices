package com.exchange.verification.util.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class VerificationConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public String clientAddress(){
        return "http://localhost:8090/api/client";
    }

    @Bean
    public String verifyClient(){
        String createController = "/verify?email={email}";
        return clientAddress() + createController;
    }

    @Bean
    public String unverifyClient(){
        String createController = "/unverify?email={email}";
        return clientAddress() + createController;
    }

}
