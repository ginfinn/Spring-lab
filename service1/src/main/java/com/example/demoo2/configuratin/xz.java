package com.example.demoo2.configuratin;

import com.example.demoo2.service.RestTemplateService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;




@Configuration
public class xz {
    @Bean
   public RestTemplate Bean() {
      RestTemplateBuilder builder =   new  RestTemplateBuilder();
        return builder.build();

    }
}
