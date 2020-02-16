package com.assignment.person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class WebConfig {

    @Bean("converter")
    MappingJackson2HttpMessageConverter getConverter(){
       return new MappingJackson2HttpMessageConverter();
    }
}


