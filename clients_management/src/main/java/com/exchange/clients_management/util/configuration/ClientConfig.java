package com.exchange.clients_management.util.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public String verificationAddress(){
        return "http://localhost:8091/api/verification";
    }

    @Bean
    public String verificationCreate(){
        String createController = "/?email={email}";
        return verificationAddress() + createController;
    }

}
