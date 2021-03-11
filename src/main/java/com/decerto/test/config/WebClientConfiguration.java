package com.decerto.test.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebClientConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .additionalMessageConverters(new StringHttpMessageConverter())
                .build();
    }
}
